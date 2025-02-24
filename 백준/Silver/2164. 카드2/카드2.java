import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<> ();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            queue.addLast(queue.pollFirst());
        }

        bw.write(queue.poll() + "\n");
        bw.flush();
        br.close(); bw.close();
    }
}
