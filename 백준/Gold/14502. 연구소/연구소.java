import java.util.*;
import java.io.*;

public class Main {
    static int n, m, answer = 0;
    static int[][] arr;

    static void dfs(int depth) {
        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1; // 벽 세우기
                    dfs(depth + 1);
                    arr[i][j] = 0; // 벽 되돌리기 (백트래킹)
                }
            }
        }
    }

    static void spreadVirus() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++)
            temp[i] = arr[i].clone();

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2)
                    q.offer(new int[] { i, j });
            }
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        q.offer(new int[] { nx, ny });
                    }
                }
            }
        }

        countSafe(temp);
    }

    static void countSafe(int[][] temp) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) count++;
            }
        }
        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
