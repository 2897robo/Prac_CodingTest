import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int idx, int depth, int teamSize) {
        if (depth == teamSize) {
            calcDiff();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, teamSize);
                visited[i] = false;
            }
        }
    }

    public static void calcDiff() {
        int start = 0, link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        min = Math.min(min, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1명부터 n/2명까지만 팀 만들기
        for (int i = 1; i <= n / 2; i++) {
            dfs(0, 0, i);
        }

        System.out.println(min);
    }
}