// BOJ 2468 - 안전 영역

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int height = 0; height <= 100; height++) {
            boolean[][] visited = new boolean[N][N];
            int safeAreas = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > height && !visited[i][j]) {
                        dfs(map, visited, i, j, height, N);
                        safeAreas++;
                    }
                }
            }

            answer = Math.max(answer, safeAreas);
        }

        System.out.println(answer);
    }

    public static void dfs(int[][] map, boolean[][] visited, int y, int x, int height, int N) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newY = y + dy[dir];
            int newX = x + dx[dir];

            if (newY >= 0 && newY < N && newX >= 0 && newX < N) {
                if (map[newY][newX] > height && !visited[newY][newX]) {
                    dfs(map, visited, newY, newX, height, N);
                }
            }
        }
    }
}
