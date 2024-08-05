import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Scanner를 통해 입력된 데이터를 처리하기 위해 hasNextLine()을 사용
        while (scanner.hasNextLine()) {
            // 한 줄씩 입력받아 출력
            String line = scanner.nextLine();
            System.out.println(line);
        }
        // Scanner를 닫음
        scanner.close();
    }
}
