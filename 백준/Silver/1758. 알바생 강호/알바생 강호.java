import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<> ();
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Collections.reverseOrder());

        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += Math.max(list.get(i) - i, 0);
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close(); bw.close();

    }
}
