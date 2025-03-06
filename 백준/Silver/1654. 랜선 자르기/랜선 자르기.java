import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] kArr = new long[k];  // long으로 변경
        long max = 0;  // 가장 긴 랜선 길이 저장

        for (int i = 0; i < k; i++) {
            kArr[i] = Long.parseLong(br.readLine());  // long 사용
            if (kArr[i] > max) max = kArr[i];  // 최댓값 저장
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (long length : kArr) {
                count += length / mid;
            }

            if (count >= n) {  // 필요한 개수 이상 만들 수 있음 -> 더 긴 길이 가능?
                answer = mid;  // 가능한 최대 길이 업데이트
                left = mid + 1;  // 길이를 더 늘려서 확인
            } else {  // 필요한 개수보다 적음 -> 길이를 줄여야 함
                right = mid - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}