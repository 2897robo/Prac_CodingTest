import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a,b;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0) {
                break;
            } else if(a%b==0) {
                System.out.println("multiple");
            } else if(b%a==0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }

    }
}