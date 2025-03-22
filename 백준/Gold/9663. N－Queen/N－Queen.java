import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;
    static int[] board; // board[row] = col : 각 행에 어떤 열에 퀸이 놓였는지 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];
        
        solve(0); // 0번째 행부터 시작
        System.out.println(count);
    }

    public static void solve(int row) {
        if (row == N) { // 퀸을 N개 모두 배치한 경우
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col; // 현재 행의 col열에 퀸을 놓아보기
            if (isSafe(row)) {
                solve(row + 1); // 다음 행으로 이동
            }
        }
    }

    // 현재 row행에 퀸을 놓았을 때, 이전의 퀸들과 충돌이 없는지 확인
    public static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) return false; // 같은 열
            if (Math.abs(i - row) == Math.abs(board[i] - board[row])) return false; // 같은 대각선
        }
        return true;
    }
}