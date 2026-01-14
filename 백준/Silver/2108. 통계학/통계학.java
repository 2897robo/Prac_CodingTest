import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum=0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int count = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;

        for(int i=0; i<N-1; i++) {
            if(arr[i] == arr[i+1]) count++;
            else {
                count++;

                if(count>max) {
                    max = count;
                    mod = arr[i];
                    check = true;
                } else if(count == max && check == true) {
                    count = 0;
                    mod = arr[i];
                    check = false;
                }
                count = 0;
            }
        }

        count++;
        if(count > max) {
            mod = arr[N-1];
        } else if(count == max && check == true) {
            mod = arr[N-1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double)sum / N)).append("\n");
        sb.append(arr[N/2]).append("\n");
        sb.append(mod).append("\n");
        sb.append(arr[N-1] - arr[0]).append("\n");

        System.out.println(sb.toString());
    }
}

