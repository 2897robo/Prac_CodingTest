import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] height = new int[n];
        int[] answer = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            height[i] = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[1] < height[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                answer[i] = stack.peek()[0] + 1;
            } else {
                answer[i] = 0;
            }

            stack.push(new int[]{i, height[i]});
        }

        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num + " ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        br.close(); bw.close();
    }
}
