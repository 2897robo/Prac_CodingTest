import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input
        int n = scanner.nextInt();
        
        // Compute the sum of integers from 1 to n
        int sum = (n * (n + 1)) / 2;
        
        // Output the result
        System.out.println(sum);
        
        // Close the scanner
        scanner.close();
    }
}
