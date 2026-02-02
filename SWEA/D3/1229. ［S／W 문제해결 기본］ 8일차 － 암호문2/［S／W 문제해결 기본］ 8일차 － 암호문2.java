// SWEA - 1229.암호문2

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            LinkedList<String> password = new LinkedList<>(Arrays.asList(br.readLine().split(" ")));
            int cmdCount = Integer.parseInt(br.readLine());
            String[] commands = br.readLine().split(" ");

            int index = 0;
            for (int i = 0; i < cmdCount; i++) {
                String cmd = commands[index++];
                if (cmd.equals("I")) {
                    int x = Integer.parseInt(commands[index++]);
                    int y = Integer.parseInt(commands[index++]);
                    for (int j = 0; j < y; j++) {
                        String value = commands[index++];
                        password.add(x + j, value);
                    }
                } else if (cmd.equals("D")) {
                    int x = Integer.parseInt(commands[index++]);
                    int y = Integer.parseInt(commands[index++]);
                    for (int j = 0; j < y; j++) {
                        password.remove(x);
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                sb.append(password.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
