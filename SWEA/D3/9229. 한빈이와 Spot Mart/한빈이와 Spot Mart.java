// SWEA 9229 - 한빈이와 Spot Mart

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] items = new int[n];
            for (int i = 0; i < n; i++) {
                items[i] = Integer.parseInt(st.nextToken());
            }

            int maxSum = -1;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = items[i] + items[j];
                    if (sum <= m && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(maxSum).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
        
    }   
}
