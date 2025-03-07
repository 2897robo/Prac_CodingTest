import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long answer = 0;

        int[] nArr = new int[n];
        int max = 0;
        for(int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nArr[i]);
        }

        long left = 1;
        long right = max * m;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;

            for(int i : nArr) {
                sum += mid / i;
                if(sum >= m) break;
            }

            if(sum >= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
