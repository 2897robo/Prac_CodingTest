import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        int max = 0;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if(scores[i] > max) {
                max = scores[i];
            }
            sum += scores[i];
        }

        System.out.println(sum * 100.0 / max / n);
    }
}
