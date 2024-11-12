import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        while(st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            if(a <= 1) {
                continue;
            }
            boolean isPrime = true;
            for(int i = 2; i * i <= a; i++) {  // 2부터 √a까지 검사
                if(a % i == 0) {
                    isPrime = false;  // 약수가 있으므로 소수가 아님
                    break;
                }
            }
            if(isPrime) {
                count++;
            }
        }

        System.out.print(count);
    }
}
