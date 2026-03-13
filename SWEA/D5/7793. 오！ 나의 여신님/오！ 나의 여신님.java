// SWEA 7793 오 나의 여신님

import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    static char[][] map;
    static Queue<int[]> suyeon;
    static Queue<int[]> devil;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            suyeon = new LinkedList<>();
            devil = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'S') suyeon.add(new int[]{i, j, 0});
                    else if (map[i][j] == '*') devil.add(new int[]{i, j});
                }
            }

            int result = solve();
            System.out.println("#" + t + " " + (result == -1 ? "GAME OVER" : result));
        }
    }

    static int solve() {
        while (!suyeon.isEmpty()) {
            // 1. 악마 확장 (현재 큐에 있는 개수만큼만 실행 - 1초분량)
            int devilSize = devil.size();
            for (int i = 0; i < devilSize; i++) {
                int[] curr = devil.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
                            map[nr][nc] = '*';
                            devil.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            // 2. 수연 이동 (현재 큐에 있는 개수만큼만 실행 - 1초분량)
            int suyeonSize = suyeon.size();
            for (int i = 0; i < suyeonSize; i++) {
                int[] curr = suyeon.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    int time = curr[2];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (map[nr][nc] == 'D') return time + 1; // 여신 도달
                        if (map[nr][nc] == '.') {
                            map[nr][nc] = 'S'; // 방문 처리
                            suyeon.add(new int[]{nr, nc, time + 1});
                        }
                    }
                }
            }
        }
        return -1; // 도달 불가
    }
}