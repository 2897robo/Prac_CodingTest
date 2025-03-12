import java.io.*;

public class Main {
    static char[][] map;

    public static void draw(int x, int y, int n) {
        if (n == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = '*';
            map[x + 2][y - 1] = '*';
            map[x + 2][y] = '*';
            map[x + 2][y + 1] = '*';
            map[x + 2][y + 2] = '*';
            return;
        }

        int half = n / 2;
        draw(x, y, half); // 위 삼각형
        draw(x + half, y - half, half); // 왼쪽 아래 삼각형
        draw(x + half, y + half, half); // 오른쪽 아래 삼각형
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                map[i][j] = ' ';
            }
        }

        draw(0, n - 1, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char[] row : map) {
            bw.write(row);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}