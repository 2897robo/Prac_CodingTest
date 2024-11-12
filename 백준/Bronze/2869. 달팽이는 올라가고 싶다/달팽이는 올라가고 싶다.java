import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken()); // 낮에 올라가는 미터
        int b = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 미터
        int v = Integer.parseInt(st.nextToken()); // 막대의 높이

        int days = (v-b) / (a-b);
        if((v-b)%(a-b) != 0) {
            days++;
        }

        System.out.print(days);
    }
}
