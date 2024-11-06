import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[4];

        for(int i=0; i<t; i++) {
            int c = sc.nextInt();
            a[0] = c/25;
            c = c%25;
            a[1] = c/10;
            c = c%10;
            a[2] = c/5;
            c = c%5;
            a[3] = c/1;

            for(int j=0; j<4; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
}