import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long m = Long.parseLong(br.readLine());

        int[] nArr = new int[n];
        for(int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        int left = 1;
        int right = nArr[n-1];
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for(int i : nArr) {
                if(i > mid) sum += mid;
                else sum += i;
            }

            if(sum <= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
