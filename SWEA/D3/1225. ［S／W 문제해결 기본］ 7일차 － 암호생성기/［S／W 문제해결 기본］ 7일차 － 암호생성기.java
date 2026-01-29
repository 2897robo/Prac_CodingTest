import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[8];
            for(int i=0; i<8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            while(true) {
                boolean terminated = false;
                for(int i=1; i<=5; i++) {
                    int first = arr[0] - i;
                    
                    for(int j=0; j<7; j++) {
                        arr[j] = arr[j+1];
                    }
                    
                    if(first <= 0) {
                        arr[7] = 0;
                        terminated = true;
                        break;
                    } else {
                        arr[7] = first;
                    }
                }
                if(terminated) break;
            }

            sb.append("#" + tc + " ");
            for(int i=0; i<8; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}