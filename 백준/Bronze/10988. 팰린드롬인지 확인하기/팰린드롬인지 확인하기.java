import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int a = 1;
        int idx = 0;
        char c1, c2;

        while(a == 1 && idx<s.length()/2) {
            c1 = s.charAt(idx);
            c2 = s.charAt(s.length() - (idx + 1));
            a = (c1 == c2) ? 1:0;
            idx++;
        }

        System.out.print(a);
    }
}
