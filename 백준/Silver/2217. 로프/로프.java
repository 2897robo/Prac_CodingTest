import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            maxWeight = Math.max(maxWeight, list.get(i) * (i + 1));
        }

        bw.write(maxWeight + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
