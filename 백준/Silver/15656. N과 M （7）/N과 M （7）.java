import java.util.*;

public class Main {
    static int n, m;
    static int[] input, answer;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            answer[depth] = input[i];
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        input = new int[n];
        answer = new int[m];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);
        dfs(0);
        System.out.print(sb);
    }
}