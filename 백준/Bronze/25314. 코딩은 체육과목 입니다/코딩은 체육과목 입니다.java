import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        int numLongs = N / 4;
        if (numLongs == 1) {
            System.out.println("long int");
        } else {
            System.out.print("long");
            for (int i = 0; i < numLongs - 1; ++i) {
                System.out.print(" long");
            }
            System.out.println(" int");
        }
    }
}
