import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int j = 2;
        for(int i=0; i<t; i++) {
            j = j+j-1;
        }
        System.out.print(j*j);
    }
}