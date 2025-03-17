import java.util.*;
import java.io.*;

public class Main {
    static int[] sour, salt;
    static int n, answer = Integer.MAX_VALUE;

    public static void dfs(int idx, int totalSour, int totalSalt, int count) {
        if(idx == n) {
            if(count > 0) {
                answer = Math.min(answer, Math.abs(totalSour - totalSalt));
            }
            return;
        }

        dfs(idx+1, totalSour * sour[idx], totalSalt + salt[idx], count + 1);

        dfs(idx+1, totalSour, totalSalt, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        salt = new int[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sour[i] = Integer.parseInt(st.nextToken());
            salt[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
