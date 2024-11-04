import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[9];
        int max = 0;
        int max_index = 0;

        for(int i=0; i<a.length; i++) {
            a[i] = sc.nextInt();
            if(a[i] > max) {
                max = a[i];
                max_index = i + 1;
            }
        }

        System.out.println(max + "\n" + max_index);
    }
}