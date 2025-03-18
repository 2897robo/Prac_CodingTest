import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minCityDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도시 정보 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) houses.add(new int[]{i, j}); // 집 저장
                else if (value == 2) chickens.add(new int[]{i, j}); // 치킨집 저장
            }
        }

        // 치킨집 조합을 선택하여 도시의 최소 치킨 거리 찾기
        selectChickens(new ArrayList<>(), 0);

        // 결과 출력
        System.out.println(minCityDistance);
    }

    // 치킨집 조합 선택 (백트래킹)
    public static void selectChickens(List<int[]> selected, int start) {
        if (selected.size() == M) { // M개 선택 완료
            minCityDistance = Math.min(minCityDistance, calculateCityDistance(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            selectChickens(selected, i + 1);
            selected.remove(selected.size() - 1); // 백트래킹
        }
    }

    // 도시의 치킨 거리 계산
    public static int calculateCityDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int houseMinDistance = Integer.MAX_VALUE;

            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                houseMinDistance = Math.min(houseMinDistance, distance);
            }

            totalDistance += houseMinDistance;
        }

        return totalDistance;
    }
}