import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        String s;
        int total = 0;

        while((s=br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            total++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String tree = entry.getKey();
            double percentage = (entry.getValue() * 100.0) / total;
            sb.append(tree).append(" ").append(String.format("%.4f", percentage)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close(); bw.close();

    }
}
