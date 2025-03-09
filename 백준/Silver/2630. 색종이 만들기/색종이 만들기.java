import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    static void divideAndConquer(int x, int y, int size) {
        if(isSameColor(x,y,size)) {
            if(paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        divideAndConquer(x, y, newSize);
        divideAndConquer(x, y+newSize, newSize);
        divideAndConquer(x + newSize, y, newSize);
        divideAndConquer(x + newSize, y + newSize, newSize);
    }

    static boolean isSameColor(int x, int y, int size) {
        int color = paper[x][y];
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, n);

        bw.write(white + "\n" + blue);
        bw.flush();
        br.close();
        bw.close();
    }
}
