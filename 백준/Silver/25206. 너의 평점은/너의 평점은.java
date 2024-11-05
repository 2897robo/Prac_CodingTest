import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> map = new HashMap<>();
        double sum = 0;
        double num_sum = 0;

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        for(int i=0; i<20; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            String c = st.nextToken();
            Double num = Double.parseDouble(st.nextToken());
            String GPA = st.nextToken();

            if(GPA.equals("P")) {
                continue;
            }

            num_sum += num;
            sum += num * map.get(GPA);
        }

        System.out.print(sum / num_sum);
    }
}
