import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sides = new int[3];
        sides[0] = sc.nextInt();
        sides[1] = sc.nextInt();
        sides[2] = sc.nextInt();
        
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        if (c >= a + b) {
            c = a + b - 1;
        }

        System.out.println(a + b + c);
    }
}
