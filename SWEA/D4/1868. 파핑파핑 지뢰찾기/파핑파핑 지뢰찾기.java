// SWEA 1868. 파핑파핑 지뢰찾기

import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    
    // 8방향 탐색용 배열 (상하좌우 + 대각선)
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

            // [1단계] 주변에 지뢰가 0개인 곳(명당)을 먼저 찾아 클릭! (연쇄 폭발)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 아직 방문 안 한 빈칸인데, 주변에 지뢰가 없다면?
                    if (map[i][j] == '.' && !visited[i][j] && countMines(i, j) == 0) {
                        clicks++;      // 클릭 횟수 증가
                        bfs(i, j);     // 물감 번지듯 쫙 퍼지게 BFS 실행
                    }
                }
            }

            // [2단계] 연쇄 폭발에 안 휘말리고 살아남은 찐따 칸들 직접 하나씩 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        clicks++;      // 남은 거 하나당 1클릭씩 추가
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(clicks).append("\n");
        }
        System.out.print(sb);
    }

    // (기능 1) 현재 내 위치 주변 8칸에 지뢰가 몇 개인지 세어주는 함수
    static int countMines(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 맵 안쪽이고 지뢰(*)라면 카운트 증가
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == '*') {
                cnt++;
            }
        }
        return cnt;
    }

    // (기능 2) 0번 칸을 눌렀을 때 주변으로 쫙 펴지는 연쇄 폭발 함수
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true; // 방문 처리

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            // "방금 꺼낸 칸도 주변 지뢰가 0개일 때만" 또 주변을 까본다!
            if (countMines(cx, cy) == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    
                    // 맵 안쪽이고, 아직 안 가본 빈칸(.)이면 모조리 열어버림
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}