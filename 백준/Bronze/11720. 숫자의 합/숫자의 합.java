import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        char[] arr = tmp.toCharArray();
        long sum = 0;

        for(int i=0; i < n; i++) {
            sum += arr[i] - '0';
        }

        System.out.println(sum);
    }
}