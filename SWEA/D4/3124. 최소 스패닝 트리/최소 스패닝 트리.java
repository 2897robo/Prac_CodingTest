// SWEA 3124 최소 스패닝 트리

import java.util.*;
import java.io.*;

public class Solution {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(a, b, c);
            }

            Arrays.sort(edges);

            parent = new int[V + 1];
            for (int i = 1; i <= V; i++) parent[i] = i;

            long totalWeight = 0;
            int count = 0;

            for (Edge edge : edges) {
                if (union(edge.from, edge.to)) {
                    totalWeight += edge.weight;
                    count++;
                    if (count == V - 1) break;
                }
            }

            sb.append("#").append(t).append(" ").append(totalWeight).append("\n");
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
