import java.io.*;
import java.util.*;

public class Main {

    static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return true; // 찾으면 true 반환
            else if (arr[mid] < target) left = mid + 1; // 오른쪽 탐색
            else right = mid - 1; // 왼쪽 탐색
        }

        return false; // 못 찾았으면 false
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (binarySearch(nArr, target)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
}
