// SWEA 5643 키순서

import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    static ArrayList<Integer>[] adj, radj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            adj = new ArrayList[N+1];
            radj = new ArrayList[N+1];
            for(int i=1; i<=N; i++) {
                adj[i] = new ArrayList<>();
                radj[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                radj[b].add(a);
            }

            // 메인 로직
            int result = 0;

            for(int i=1; i<=N; i++) {
                int tallerCount = bfs(i, adj);
                int shorterCount = bfs(i, radj);

                if(tallerCount + shorterCount == N-1) {
                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int start, ArrayList<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.offer(start);
        visited[start] = true;
        int count = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}
