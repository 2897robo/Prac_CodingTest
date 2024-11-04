import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        boolean[] a = new boolean[30];
        for(int i=0; i<28; i++) {
            a[sc.nextInt()-1] = true;
        }

        for(int i=0; i<a.length; i++) {
            if(!a[i]) {
                System.out.println(i+1);
            }
        }
    }
}