// SWEA 1251 하나로

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            long[] X = new long[N];
            long[] Y = new long[N];

            StringTokenizer stX = new StringTokenizer(br.readLine());
            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Long.parseLong(stX.nextToken());
                Y[i] = Long.parseLong(stY.nextToken());
            }

            double E = Double.parseDouble(br.readLine().trim());

            boolean[] visited = new boolean[N];
            double[] minEdge = new double[N];
            Arrays.fill(minEdge, Double.MAX_VALUE);
            
            double totalCost = 0;
            minEdge[0] = 0;

            for (int i = 0; i < N; i++) {
                double min = Double.MAX_VALUE;
                int current = -1;

                for (int j = 0; j < N; j++) {
                    if (!visited[j] && min > minEdge[j]) {
                        min = minEdge[j];
                        current = j;
                    }
                }

                if (current == -1) break;
                
                visited[current] = true;
                totalCost += min;

                for (int j = 0; j < N; j++) {
                    if (!visited[j]) {
                        long dx = X[current] - X[j];
                        long dy = Y[current] - Y[j];
                        double cost = E * (dx * dx + dy * dy);
                        if (minEdge[j] > cost) {
                            minEdge[j] = cost;
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(Math.round(totalCost)).append("\n");
        }
        System.out.print(sb);
    }
}