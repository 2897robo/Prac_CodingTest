import java.util.*;
import java.io.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> hear = new HashSet<> ();
        Set<String> set = new HashSet<> ();
        int cnt = 0;

        for(int i=0; i<n; i++) {
            hear.add(br.readLine());
        }
        for(int j=0; j<m; j++) {
            String tmp = br.readLine();
            if(hear.contains(tmp)) {
                set.add(tmp);
                cnt++;
            }
        }

        List<String> answer = new ArrayList<> (set);
        Collections.sort(answer);

        bw.write(answer.size() + "\n");
        for(String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();

        br.close(); bw.close();
    }
}