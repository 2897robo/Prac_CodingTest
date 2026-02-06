// SWEA - 5215 햄버거 다이어트

import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static int[] calories;
    static int[] tastes;
    static int maxTaste;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            calories = new int[n];
            tastes = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                tastes[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            maxTaste = 0;
            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(maxTaste).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int index, int currentTaste, int currentCalories) {
        if (currentCalories > m) {
            return;
        }
        if (index == n) {
            maxTaste = Math.max(maxTaste, currentTaste);
            return;
        }

        dfs(index + 1, currentTaste + tastes[index], currentCalories + calories[index]);
        dfs(index + 1, currentTaste, currentCalories);
    }
}
