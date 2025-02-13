import java.util.*;
import java.io.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> hear = new HashSet<>(); // 듣도 못한 사람 저장
        List<String> answer = new ArrayList<>(); // 듣보잡 명단 저장

        for (int i = 0; i < n; i++) {
            hear.add(br.readLine());
        }

        for (int j = 0; j < m; j++) {
            String name = br.readLine();
            if (hear.contains(name)) {
                answer.add(name); // 중복이 없으므로 바로 리스트에 추가 가능
            }
        }

        br.close();

        Collections.sort(answer); // 사전순 정렬

        System.out.println(answer.size());
        for (String name : answer) {
            System.out.println(name);
        }
    }
}
