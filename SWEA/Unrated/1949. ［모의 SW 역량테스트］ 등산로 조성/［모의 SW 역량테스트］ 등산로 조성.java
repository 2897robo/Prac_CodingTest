// SWEA 1949 등산로 조성

import java.util.*;
import java.io.*;

public class Solution {
    static int N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int maxRoute;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            visited = new boolean[N][N];

            int maxH = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] > maxH) maxH = arr[i][j];
                }
            }

            maxRoute = 0;
            // logic
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] == maxH) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false);
                        visited[i][j] = false;
                    }
                }
            }

            sb.append(maxRoute).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int r, int c, int len, boolean usedK) {
        if(len > maxRoute) maxRoute = len;

        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];

            if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc]) continue;

            if(arr[nr][nc] < arr[r][c]) {
                visited[nr][nc] = true;
                dfs(nr, nc, len+1, usedK);
                visited[nr][nc] = false;
            } else {
                if(!usedK && arr[nr][nc] - K < arr[r][c]) {
                    int originH = arr[nr][nc];

                    arr[nr][nc] = arr[r][c] - 1;
                    visited[nr][nc] = true;
                    dfs(nr, nc, len+1, true);
                    visited[nr][nc] = false;
                    arr[nr][nc] = originH;
                }
            }
        }
    }
}
