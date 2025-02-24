import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int idx = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            list.add(i+1);
        }

        while(!list.isEmpty()) {
            idx = (idx + k -1) % list.size();

            if(list.size() > 1) {
                sb.append(list.remove(idx)).append(", ");
            } else {
                sb.append(list.remove(idx));
            }
        }

        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        br.close(); bw.close();

    }
}
