// SWEA 1233 - 사칙연산유효성검사

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean isValid = true;

            for (int i = 1; i <= n; i++) {
                String[] parts = br.readLine().split(" ");
                if (parts.length == 2) { // Leaf node
                    char value = parts[1].charAt(0);
                    if (value < '0' || value > '9') { // Not a digit
                        isValid = false;
                    }
                } else if (parts.length == 4) { // Internal node
                    char value = parts[1].charAt(0);
                    if (value >= '0' && value <= '9') { // Is a digit
                        isValid = false;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(isValid ? 1 : 0).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
