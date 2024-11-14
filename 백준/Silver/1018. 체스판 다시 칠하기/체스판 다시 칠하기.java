import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 보드 입력 받기
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        // 최소 색칠 횟수를 큰 값으로 설정
        int minChanges = Integer.MAX_VALUE;

        // 8x8 체스판을 자르면서 확인
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 첫 번째 체스판 (왼쪽 위가 흰색)
                int changes1 = countChanges(board, i, j, 'W');
                // 두 번째 체스판 (왼쪽 위가 검은색)
                int changes2 = countChanges(board, i, j, 'B');

                // 두 체스판의 최소 변경 횟수 구하기
                minChanges = Math.min(minChanges, Math.min(changes1, changes2));
            }
        }

        // 결과 출력
        System.out.println(minChanges);
    }

    // 주어진 시작점에서 8x8 체스판을 자르고, 변경해야 하는 칸의 개수를 계산
    public static int countChanges(char[][] board, int startX, int startY, char firstColor) {
        int changes = 0;
        char expectedColor = firstColor;  // 첫 번째 칸의 색

        // 8x8 체스판을 확인
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 현재 칸이 예상 색과 다르면 변경해야 하므로 changes 증가
                if (board[startX + i][startY + j] != expectedColor) {
                    changes++;
                }
                // 예상 색을 번갈아가며 바꾸기
                expectedColor = (expectedColor == 'W') ? 'B' : 'W';
            }
            // 한 행을 다 처리한 후, 첫 번째 칸의 색을 다시 바꿔줌
            expectedColor = (expectedColor == 'W') ? 'B' : 'W';
        }

        return changes;
    }
}
