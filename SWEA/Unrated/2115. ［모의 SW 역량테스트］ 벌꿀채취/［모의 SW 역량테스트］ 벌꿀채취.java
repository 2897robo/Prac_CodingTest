// SWEA - 2115 벌꿀채취

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] honey = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxProfit = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int firstProfit = getMaxProfit(honey, i, j, m, c);

                    for (int x = i; x < n; x++) {
                        for (int y = 0; y <= n - m; y++) {
                            if (x == i && y < j + m) continue;

                            int secondProfit = getMaxProfit(honey, x, y, m, c);
                            maxProfit = Math.max(maxProfit, firstProfit + secondProfit);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(maxProfit).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


    private static int getMaxProfit(int[][] honey, int row, int col, int m, int c) {
        int maxProfit = 0;
        int limit = 1 << m;

        for (int subset = 0; subset < limit; subset++) {
            int sum = 0;
            int profit = 0;

            for (int k = 0; k < m; k++) {
                if ((subset & (1 << k)) != 0) {
                    sum += honey[row][col + k];
                    profit += honey[row][col + k] * honey[row][col + k];
                }
            }

            if (sum <= c) {
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
