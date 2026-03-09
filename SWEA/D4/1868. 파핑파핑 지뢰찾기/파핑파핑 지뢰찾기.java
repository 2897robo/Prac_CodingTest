// SWEA 1868. 파핑파핑 지뢰찾기

import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int clicks = 0;

            // 주변에 지뢰가 0개인 곳
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && countMines(i, j) == 0) {
                        clicks++;
                        bfs(i, j);
                    }
                }
            }

            // 살아남은 찐따 칸들
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        clicks++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(clicks).append("\n");
        }
        System.out.print(sb);
    }

    static int countMines(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == '*') {
                cnt++;
            }
        }
        return cnt;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (countMines(cx, cy) == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}