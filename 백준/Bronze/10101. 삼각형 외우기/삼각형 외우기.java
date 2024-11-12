import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String s;

        if(a==60 && b==60 && c==60) {
            s = "Equilateral";
        } else if(a+b+c==180 && (a==b || b==c || a==c)) {
            s = "Isosceles";
        } else if(a+b+c==180) {
            s = "Scalene";
        } else {
            s = "Error";
        }
        System.out.print(s);
    }
}
