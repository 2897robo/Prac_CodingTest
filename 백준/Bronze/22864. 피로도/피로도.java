import java.io.*;
import java.util.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int work = 0;
        int tired = 0;

        for(int i=0; i<24; i++) {
            if((tired + a) <= m) {
                work+=b;
                tired+=a;
            }
            else {
                tired = Math.max(0, tired - c);
            }
        }

        bw.write(work + "\n");
        bw.flush();
        br.close(); bw.close();
    }
}