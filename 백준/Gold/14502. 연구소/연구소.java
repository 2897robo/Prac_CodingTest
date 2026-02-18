import java.util.*;
import java.io.*;

public class Main {
    static int N, M, result;
    static int[][] arr;
    // 상하좌우 이동 (전역 변수 활용)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;

        // logic: 벽 세우기 시작
        // depth: 0개 세움, start: 0번 인덱스부터 탐색 시작
        dfs(0, 0);

        sb.append(result).append("\n");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    // [최적화 적용] 1차원 인덱스(idx)를 사용하여 중복 없는 조합 구현
    static void dfs(int depth, int start) {
        // 기저 조건: 벽 3개를 다 세웠으면 바이러스 퍼뜨리기
        if (depth == 3) {
            spreadVirus();
            return;
        }

        // start부터 끝(N*M)까지 탐색 (이전에 세운 벽 다음 칸부터 봄)
        for (int k = start; k < N * M; k++) {
            int r = k / M; // 행 계산
            int c = k % M; // 열 계산

            if (arr[r][c] == 0) {
                arr[r][c] = 1;         // 벽 세우기
                dfs(depth + 1, k + 1); // 다음 재귀는 현재 칸(k)의 다음 칸부터
                arr[r][c] = 0;         // 벽 허물기 (백트래킹)
            }
        }
    }

    static void spreadVirus() {
        // 1. 맵 복사 (원본 보호)
        int[][] temp = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            temp[i] = arr[i].clone(); // 행 단위 복사 (깊은 복사 효과)
            for(int j=0; j<M; j++) {
                // 바이러스 위치 미리 큐에 넣기 (2중 for문 줄이기 위함)
                if(temp[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        // 2. BFS 탐색
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if(temp[nr][nc] == 0) {
                        temp[nr][nc] = 2; // 바이러스 전파
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        // 3. 안전 영역 계산
        countSafe(temp);
    }

    static void countSafe(int[][] temp) {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(temp[i][j] == 0) count++;
            }
        }
        // 최대값 갱신
        if(count > result) result = count;
    }
}
