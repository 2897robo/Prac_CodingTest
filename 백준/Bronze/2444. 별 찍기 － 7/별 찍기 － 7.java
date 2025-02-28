import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<n; i++) {
            for(int j=n-i; j>0; j--) {
                System.out.print(" ");
            }
            for(int k=1; k<2*i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0; i<2*n-1; i++) {
            System.out.print("*");
        }
        System.out.println();

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                System.out.print(" ");
            }
            for(int k=2*n-2*i-1; k>0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
