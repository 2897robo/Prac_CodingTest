import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long cnt = 0;
        for(long i=n-1; i>0; i--) {
            cnt += i;
        }
        System.out.print(cnt + "\n" + 2);
    }
}