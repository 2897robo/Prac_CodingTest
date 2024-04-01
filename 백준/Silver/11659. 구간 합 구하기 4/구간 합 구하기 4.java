import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] tmp = new long[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            tmp[i] = tmp[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<m; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(tmp[b] - tmp[a-1]);
        }
    }
}