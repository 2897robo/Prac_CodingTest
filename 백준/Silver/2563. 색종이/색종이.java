// BOJ 2563 - 색종이

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int canvasSize = 100;
        boolean[][] canvas = new boolean[canvasSize][canvasSize];

        int numPapers = Integer.parseInt(br.readLine());

        for (int i = 0; i < numPapers; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    canvas[j][k] = true;
                }
            }
        }

        int blackArea = 0;
        for (int i = 0; i < canvasSize; i++) {
            for (int j = 0; j < canvasSize; j++) {
                if (canvas[i][j]) {
                    blackArea++;
                }
            }
        }

        System.out.println(blackArea);
    }
}
