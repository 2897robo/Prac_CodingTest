import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // N이 1이면 출력하지 않음
        if (n == 1) {
            return;
        }

        // 2부터 시작해서 n의 제곱근 이하의 수까지 나눔
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {  // i로 나누어 떨어질 동안 계속 나눔
                System.out.println(i);
                n /= i;
            }
        }

        // 나누고 남은 수가 1보다 크면 그 수는 소수
        if (n > 1) {
            System.out.println(n);
        }
    }
}
