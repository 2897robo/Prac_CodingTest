import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] c = new char[5][15];
        int l = 0;

        for(int i=0; i<5; i++) {
            String s = br.readLine();
            if(l < s.length()) {
                l = s.length();
            }

            for(int j=0; j<s.length(); j++) {
                c[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<l; i++) {
            for(int j=0; j<5; j++) {
                if(c[j][i] == '\0') {
                    continue;
                }
                sb.append(c[j][i]);
            }
        }

        System.out.println(sb);
    }
}