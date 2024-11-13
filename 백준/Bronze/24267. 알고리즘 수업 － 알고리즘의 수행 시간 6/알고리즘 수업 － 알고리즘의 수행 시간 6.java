import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // 세 변수를 선택하는 조합의 개수
        long cnt = (n * (n - 1) * (n - 2)) / 6;

        System.out.println(cnt + "\n" + 3);
    }
}
