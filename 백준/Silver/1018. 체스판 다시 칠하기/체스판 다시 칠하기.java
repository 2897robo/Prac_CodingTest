// BOJ 1018 체스판 다시 칠하기

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) == 'W' ? 0 : 1;
            }
        }

        int minRepaint = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, repaintCount(i, j));
            }
        }
        System.out.println(minRepaint);
    }

    private static int repaintCount(int startX, int startY) {
        int repaintWhite = 0; // Starting with white
        int repaintBlack = 0; // Starting with black

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int expectedColor = (i + j) % 2; // 0 for white, 1 for black
                if (board[startX + i][startY + j] != expectedColor) {
                    repaintWhite++;
                } else {
                    repaintBlack++;
                }
            }
        }
        return Math.min(repaintWhite, repaintBlack);
    }

}