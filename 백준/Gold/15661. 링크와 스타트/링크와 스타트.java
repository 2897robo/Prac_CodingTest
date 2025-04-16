import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int depth, int idx, int target) {
        if (depth == target) {
            calcDiff();
            return;
        }

        for (int i = idx; i < n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1, target);
            visited[i] = false;
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

        min = Math.min(min, Math.abs(start - link));
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

        for (int i = 1; i <= n / 2; i++) { // 양쪽 모두 한 명 이상이어야 하므로
            dfs(0, 0, i);
        }

        System.out.println(min);
    }
}