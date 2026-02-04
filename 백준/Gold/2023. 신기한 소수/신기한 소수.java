// BOJ 2023 - 신기한 소수

import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb.toString());
    }


    public static void dfs(int number, int digit) {
        if (digit == N) {
            sb.append(number).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int nextNum = number * 10 + i;

            if (isPrime(nextNum)) {
                dfs(nextNum, digit + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}