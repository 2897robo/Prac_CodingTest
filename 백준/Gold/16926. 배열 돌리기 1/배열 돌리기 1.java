import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<R; k++) {
            rotate();
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            for(int j : arr[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void rotate() {
        int count = Math.min(N, M) / 2;
        
        for(int j=0; j<count; j++) {
            int temp = arr[j][j];

            // 위쪽줄 왼쪽으로
            for (int k = j + 1; k < M - j; k++) {
                arr[j][k - 1] = arr[j][k];
            }
            // 오른쪽 줄 위로
            for (int k = j + 1; k < N - j; k++) {
                arr[k - 1][M - j - 1] = arr[k][M - j - 1];
            }
            // 아랫 줄 우측으로
            for (int k = M - 2 - j; k >= j; k--) {
                arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
            }
            // 왼줄 아래로
            for (int k = N - j - 2; k >= j; k--) {
                arr[k + 1][j] = arr[k][j];
            }
            // 시작값 한칸 아래로
            arr[j + 1][j] = temp;
        }
    }
}