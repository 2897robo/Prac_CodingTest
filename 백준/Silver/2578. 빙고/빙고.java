// BOJ 2579 빙고

import java.util.*;
import java.io.*;
public class Main {
    static int[][] map = new int[5][5];
    static int[][] visited = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (map[k][l] == num) {
                            visited[k][l] = 1;
                        }
                    }
                }
                if (check()) {
                    sb.append(i * 5 + j + 1);
                    break;
                }
            }
            if (sb.length() > 0) {
                break;
            }
        }

        System.out.println(sb);

    }

    static boolean check() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += visited[i][j];
            }
            if (sum == 5) {
                count++;
            }
        }

        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += visited[j][i];
            }
            if (sum == 5) {
                count++;
            }
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 5; i++) {
            sum1 += visited[i][i];
            sum2 += visited[i][4 - i];
        }
        if (sum1 == 5) {
            count++;
        }
        if (sum2 == 5) {
            count++;
        }

        return count >= 3;
    }

}