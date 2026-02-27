// BOJ 2579 빙고

import java.util.*;
import java.io.*;
public class Main {
    static int[][] visited = new int[5][5];
    static Map<Integer, int[]> position = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 빙고판 읽기 및 위치 저장
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                position.put(num, new int[]{i, j});
            }
        }

        // 불리는 숫자 처리
        int count = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                count++;
                
                // 이미 맵에 있는 숫자면 체크
                if (position.containsKey(num)) {
                    int[] pos = position.get(num);
                    visited[pos[0]][pos[1]] = 1;
                }
                
                // 빙고 완성되면 출력
                if (count > 3 && check()) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    static boolean check() {
        int count = 0;
        
        // 행 체크
        for (int i = 0; i < 5; i++) {
            if (countSum(visited[i]) == 5) count++;
        }
        
        // 열 체크
        for (int j = 0; j < 5; j++) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += visited[i][j];
            }
            if (sum == 5) count++;
        }
        
        // 대각선 체크
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < 5; i++) {
            diag1 += visited[i][i];
            diag2 += visited[i][4 - i];
        }
        if (diag1 == 5) count++;
        if (diag2 == 5) count++;
        
        return count >= 3;
    }
    
    static int countSum(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

}