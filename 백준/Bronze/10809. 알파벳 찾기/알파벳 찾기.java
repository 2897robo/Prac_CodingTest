import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(char c = 'a'; c <= 'z'; c++) {
            System.out.print(input.indexOf(c) + " ");
        }
    }
}
