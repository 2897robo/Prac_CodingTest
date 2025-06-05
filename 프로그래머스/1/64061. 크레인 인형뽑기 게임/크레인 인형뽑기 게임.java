import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int answer = 0;

        List<Deque<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayDeque<>());
        }

        for (int j = 0; j < n; j++) {       
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    arr.get(j).push(board[i][j]);
                }
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int move : moves) {
            Deque<Integer> column = arr.get(move - 1);
            if (!column.isEmpty()) {
                int doll = column.pop();
                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);
                }
            }
        }

        return answer;
    }
}