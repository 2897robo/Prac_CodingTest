import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> answer = new ArrayList<> ();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = n-1;

        while(i<j) {
            int tmp = arr[i] + arr[j];
            if(Math.abs(tmp) < min) {
                min = Math.abs(tmp);
                answer.clear();
                answer.add(arr[i]);
                answer.add(arr[j]);
            }

            if(tmp > 0) {
                j--;
            } else {
                i++;
            }
        }

        bw.write(answer.get(0) + " " + answer.get(1) + "\n" );
        bw.flush();
        br.close(); bw.close();
    }
}
