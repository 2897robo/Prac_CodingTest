import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // N단 입력 받기
        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i + " = " + (N * i)); // 구구단 출력
        }
        scanner.close();
    }
}
