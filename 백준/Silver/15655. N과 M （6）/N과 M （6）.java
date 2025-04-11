import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr, answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1, i + 1);  // 다음 인덱스부터 탐색 (오름차순 유지)
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 사전순 출력을 위해 정렬

        dfs(0, 0);

        System.out.print(sb);
    }
}