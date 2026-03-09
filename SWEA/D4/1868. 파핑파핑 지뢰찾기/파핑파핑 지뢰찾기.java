// SWEA 1868 - Minesweeper

import java.util.*;
import java.io.*;

public class Solution {
	static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
	static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[][] board = new char[N][N];

			for (int r = 0; r < N; r++) {
				board[r] = br.readLine().toCharArray();
			}

			int[][] aroundMine = new int[N][N];
			boolean[][] opened = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == '*') {
						aroundMine[r][c] = -1;
						continue;
					}

					int cnt = 0;
					for (int d = 0; d < 8; d++) {
						int nr = r + DR[d];
						int nc = c + DC[d];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
							continue;
						}
						if (board[nr][nc] == '*') {
							cnt++;
						}
					}
					aroundMine[r][c] = cnt;
				}
			}

			int clicks = 0;

			// Clicking a zero cell opens connected zero area and its boundary cells.
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == '*' || opened[r][c] || aroundMine[r][c] != 0) {
						continue;
					}

					clicks++;
					bfsOpen(r, c, N, board, aroundMine, opened);
				}
			}

			// Remaining safe cells each require one direct click.
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == '.' && !opened[r][c]) {
						clicks++;
					}
				}
			}

			sb.append('#').append(tc).append(' ').append(clicks).append('\n');
		}

		System.out.print(sb);
	}

	static void bfsOpen(int sr, int sc, int n, char[][] board, int[][] aroundMine, boolean[][] opened) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{sr, sc});
		opened[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			if (aroundMine[r][c] != 0) {
				continue;
			}

			for (int d = 0; d < 8; d++) {
				int nr = r + DR[d];
				int nc = c + DC[d];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
					continue;
				}
				if (board[nr][nc] == '*' || opened[nr][nc]) {
					continue;
				}

				opened[nr][nc] = true;
				if (aroundMine[nr][nc] == 0) {
					q.offer(new int[]{nr, nc});
				}
			}
		}
	}

}
