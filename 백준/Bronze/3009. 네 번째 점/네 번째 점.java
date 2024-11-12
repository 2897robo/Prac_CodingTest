import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1, x2, x3, y1, y2, y3, x4, y4;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        if(x1==x2) {
            x4 = x3;
            y4 = calculation(y1, y2, y3);
        } else if(x1==x3) {
            x4 = x2;
            y4 = calculation(y1, y2, y3);
        } else {
            x4 = x1;
            y4 = calculation(y1, y2, y3);
        }

        System.out.print(x4 + " " + y4);
    }

    public static int calculation(int y1, int y2, int y3) {
        if(y1==y2) return y3;
        else if(y1==y3) return y2;
        else return y1;
    }
}