import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int maxH = 0;
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] > maxH) maxH = arr[i];
            }

            //메인 로직
            long result = 0;
            long cnt1=0, cnt2=0;

            for(int i=0; i<N; i++) {
                int diff = maxH - arr[i];
                cnt2 += diff/2;
                cnt1 += diff%2;
            }

            while(cnt2 > cnt1 + 1) {
                cnt2--;
                cnt1 += 2;
            }

            if(cnt1 > cnt2) result = cnt1 * 2 - 1;
            else result = cnt2*2;

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
