import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] nArr;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = nArr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[m];
        nArr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
