import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 숫자 카드의 개수 N
        int n = Integer.parseInt(br.readLine());

        // 숫자 카드에 적힌 숫자들 (N개의 숫자)
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 해당 숫자가 이미 map에 있으면 값을 1 증가
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 셋째 줄에 몇 개 가지고 있는지 구해야할 수의 개수 M
        int m = Integer.parseInt(br.readLine());

        // 네 번째 줄에 M개의 숫자
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(st.nextToken());
            // 각 query에 대해 map에 존재하는지 확인하고, 값이 있으면 출력, 없으면 0 출력
            sb.append(map.getOrDefault(query, 0)).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
