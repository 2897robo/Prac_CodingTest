import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push" :
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(deque.isEmpty() ? "-1\n" : deque.poll() + "\n");
                    break;
                case "size" :
                    sb.append(deque.size() + "\n");
                    break;
                case "empty" :
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front" :
                    sb.append(deque.isEmpty() ? "-1\n" : deque.peekFirst()+"\n");
                    break;
                case "back" :
                    sb.append(deque.isEmpty() ? "-1\n" : deque.peekLast()+"\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close(); bw.close();

    }
}
