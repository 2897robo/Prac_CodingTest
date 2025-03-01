import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 아이스크림 종류 수
        int M = Integer.parseInt(st.nextToken()); // 섞으면 안 되는 조합 수

        boolean[][] forbidden = new boolean[N + 1][N + 1];

        // 섞어 먹으면 안 되는 조합 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            forbidden[a][b] = true;
            forbidden[b][a] = true; // 양방향 설정
        }

        int count = 0;

        // 3개 아이스크림을 고르는 모든 경우의 수 확인 (브루트포스)
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    // (i, j), (j, k), (i, k) 조합이 금지된 조합이면 패스
                    if (forbidden[i][j] || forbidden[j][k] || forbidden[i][k]) continue;

                    count++; // 조건을 만족하는 조합 카운트 증가
                }
            }
        }

        System.out.println(count);
    }
}