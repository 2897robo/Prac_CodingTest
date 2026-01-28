import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            String memory = sc.next();
            char prev = '0';
            int count = 0;

            for (char c : memory.toCharArray()) {
                if (c != prev) {
                    count++;
                    prev = c;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
