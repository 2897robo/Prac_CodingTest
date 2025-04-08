import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            result[depth] = i;
            dfs(depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
