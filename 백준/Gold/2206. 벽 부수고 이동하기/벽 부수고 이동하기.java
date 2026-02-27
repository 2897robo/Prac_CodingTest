// BOJ 2206 벽 부수고 이동하기

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = 0;
        
        // 메인 로직
        answer = bfs();


        sb.append(answer).append("\n");
        System.out.print(sb);

    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2]; // 벽을 부쉈는지 여부

        q.offer(new int[]{0, 0, 0}); // x, y, 벽 부순 여부
        visited[0][0][0] = true;

        int steps = 1; // 시작 위치도 포함

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int x = current[0];
                int y = current[1];
                int broken = current[2];

                if (x == n - 1 && y == m - 1) {
                    return steps; // 도착 지점에 도달
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                            visited[nx][ny][broken] = true;
                            q.offer(new int[]{nx, ny, broken});
                        } else if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.offer(new int[]{nx, ny, 1});
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // 도착 지점에 도달할 수 없는 경우
    }
}