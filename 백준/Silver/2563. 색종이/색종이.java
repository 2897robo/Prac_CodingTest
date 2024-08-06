import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 도화지의 크기는 100x100
        int canvasSize = 100;
        boolean[][] canvas = new boolean[canvasSize][canvasSize];

        // 색종이의 수를 입력받음
        int numPapers = scanner.nextInt();

        // 각 색종이의 위치를 입력받아 도화지에 표시
        for (int i = 0; i < numPapers; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // 색종이는 10x10 크기
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    // 해당 위치를 true로 표시 (색종이가 붙어 있음을 표시)
                    canvas[j][k] = true;
                }
            }
        }

        // 검은 영역의 넓이를 계산
        int blackArea = 0;
        for (int i = 0; i < canvasSize; i++) {
            for (int j = 0; j < canvasSize; j++) {
                if (canvas[i][j]) {
                    blackArea++;
                }
            }
        }

        // 결과 출력
        System.out.println(blackArea);

        // Scanner 객체 닫기
        scanner.close();
    }
}
