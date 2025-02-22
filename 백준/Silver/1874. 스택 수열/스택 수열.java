import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int tmp = 1;
        boolean b = true;

        for(int num : answer) {
            while(tmp <= num) {
                stack.push(tmp++);
                sb.append("+\n");
            }

            if(stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                b = false;
                break;
            }
        }

        bw.write(b ? sb.toString() : "NO\n");
        bw.flush();
        br.close(); bw.close();
    }
}
