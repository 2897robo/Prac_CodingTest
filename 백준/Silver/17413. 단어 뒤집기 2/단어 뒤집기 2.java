import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        boolean inTag = false;

        for(char c : s.toCharArray()) {
            if(c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(c);
            } else if(c == '>') {
                inTag = false;
                sb.append(c);
            } else if(inTag) {
                sb.append(c);
            } else {
                if(c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        br.close(); bw.close();
    }
}
