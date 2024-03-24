import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수 입력 받기
        
        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt(); // A 입력 받기
            int B = scanner.nextInt(); // B 입력 받기
            System.out.println(A + B); // A+B 출력
        }
        scanner.close();
    }
}
