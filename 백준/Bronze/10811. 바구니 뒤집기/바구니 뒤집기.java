import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] pocket = new int[n];
        for (int i = 0; i < n; i++) {
            pocket[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            
            while (j < k) {
                int temp = pocket[j];
                pocket[j] = pocket[k];
                pocket[k] = temp;
                j++;
                k--;
            }
        }

        for (int i : pocket) {
            System.out.print(i + " ");
        }
    }
}
