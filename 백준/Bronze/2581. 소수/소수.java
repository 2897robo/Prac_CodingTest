import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // 1은 소수가 아니므로, m이 1일 때 m을 2로 설정
        if (m == 1) {
            m = 2;
        }

        int sum = 0;
        int min = -1;

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
                if (min == -1) { // 첫 소수를 min에 저장
                    min = i;
                }
            }
        }

        if (sum == 0) { // 소수가 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int j = 2; j * j <= num; j++) {
            if (num % j == 0) return false;
        }
        return true;
    }
}
