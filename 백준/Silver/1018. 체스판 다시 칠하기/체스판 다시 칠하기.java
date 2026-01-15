import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int count = Integer.MAX_VALUE;

        for(int i=0; i<=n-8; i++) {
            for(int j=0; j<=m-8; j++) {
                int ch1 = countChange(board, i, j, 'W');

                int ch2 = countChange(board, i, j, 'B');

                count = Math.min(count, Math.min(ch1, ch2));
            }
        }

        System.out.println(count);
    }

    public static int countChange(char[][] board, int startX, int startY, char firstColor) {
        int changes = 0;
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(board[startX+i][startY+j] != firstColor) {
                    changes++;
                }

                firstColor = (firstColor == 'W') ? 'B' : 'W';
            }

            firstColor = (firstColor == 'W') ? 'B' : 'W';
        }

        return changes;
    }
}