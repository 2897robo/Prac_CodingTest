import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, via, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, from);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 이동 횟수 계산
        BigInteger moves = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        System.out.println(moves);

        // 이동 경로 출력 (N이 20 이하인 경우)
        if (N <= 20) {
            hanoi(N, 1, 3, 2);
            System.out.print(sb.toString());
        }
    }
}