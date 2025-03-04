import java.util.*;

public class Main {
    static int N, S, count = 0;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        findSubsequences(0, 0, false);
        System.out.println(count);
    }

    static void findSubsequences(int index, int sum, boolean included) {
        if (index == N) {
            if (included && sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 포함하는 경우
        findSubsequences(index + 1, sum + numbers[index], true);

        // 현재 원소를 포함하지 않는 경우
        findSubsequences(index + 1, sum, included);
    }
}
