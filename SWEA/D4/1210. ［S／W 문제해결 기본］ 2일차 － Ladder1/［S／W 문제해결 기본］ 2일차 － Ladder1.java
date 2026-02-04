// SWEA 1210 - Ladder1

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++) {
            sb.append("#").append(tc).append(" ");
            br.readLine();
            int[][] ladder = new int[100][100];

            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int startCol = 0;
            for(int j=0; j<100; j++) {
                if(ladder[99][j] == 2) {
                    startCol = j;
                    break;
                }
            }

            int y = 99;
            int x = startCol;

            while(y > 0) {
                if(x > 0 && ladder[y][x - 1] == 1) {
                    while(x > 0 && ladder[y][x - 1] == 1) {
                        x--;
                    }
                    y--;
                } else if(x < 99 && ladder[y][x + 1] == 1) {
                    while(x < 99 && ladder[y][x + 1] == 1) {
                        x++;
                    }
                    y--;
                } else {
                    y--;
                }
            }

            sb.append(x).append("\n");
        }

        System.out.print(sb.toString());
    }
}
