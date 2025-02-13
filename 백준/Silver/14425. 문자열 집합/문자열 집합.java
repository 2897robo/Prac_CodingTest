import java.util.*;
import java.io.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> setS = new HashSet<> ();
        int cnt = 0;
        for(int i=0; i<n; i++) {
            setS.add(br.readLine());
        }
        for(int i=0; i<m; i++) {
            if(setS.contains(br.readLine())) cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        br.close(); bw.close();
    }
}