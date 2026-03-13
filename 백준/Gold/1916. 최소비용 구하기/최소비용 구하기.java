// BOJ 1916 최소비용 구하기

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int v, w;
    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main {
    static int N, M;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startNode, endNode));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) continue;

            for (Node next : adj[curr.v]) {
                if (dist[next.v] > dist[curr.v] + next.w) {
                    dist[next.v] = dist[curr.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist[end];
    }
}