// 백준 4485 녹색옷 젤다

import java.util.*;
import java.io.*;

public class Main {
    static int N, result;
    static int[][] arr;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc=1;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            sb.append("Problem ").append(tc++).append(": ");
            arr = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            result = dijk();

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static int dijk() {
        PriorityQueue<Node> pq = new PriorityQueue<> ();

        dist[0][0] = arr[0][0];
        pq.offer(new Node(0, 0, arr[0][0]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int cost = cur.cost;

            if(r==N-1 && c==N-1) return cost;

            if(cost > dist[r][c]) continue;

            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];

                if(nr>=0 && nc>=0 && nr<N && nc<N) {
                    if(dist[nr][nc] > cost + arr[nr][nc]) {
                        dist[nr][nc] = cost + arr[nr][nc];
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }

        return -1;
    }
}