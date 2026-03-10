// SWEA 1251 하나로

import java.util.*;
import java.io.*;

public class Solution {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int start, end;
        double cost;

        Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

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

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dx = X[i] - X[j];
                    long dy = Y[i] - Y[j];
                    double cost = E * (dx * dx + dy * dy);
                    edges.add(new Edge(i, j, cost));
                }
            }

            Collections.sort(edges);

            parent = new int[N];
            for (int i = 0; i < N; i++) parent[i] = i;

            double totalCost = 0;
            int count = 0;
            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    totalCost += edge.cost;
                    count++;
                    if (count == N - 1) break;
                }
            }
            sb.append("#").append(t).append(" ").append(Math.round(totalCost)).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
            return true;
        }
        return false;
    }
}
