public class Solution {
    public static int[][] solution(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int x = 0, y = 0;
        int direction = 0; // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < n * n; i++) {
            result[x][y] = num++;
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || result[nextX][nextY] != 0) {
                direction = (direction + 1) % 4;
                nextX = x + dx[direction];
                nextY = y + dy[direction];
            }

            x = nextX;
            y = nextY;
        }

        return result;
    }
}
