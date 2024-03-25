import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the total amount from the receipt
        int totalAmount = scanner.nextInt();
        
        // Read the number of items purchased
        int numItems = scanner.nextInt();
        
        // Calculate the total amount from individual items
        int calculatedTotal = 0;
        for (int i = 0; i < numItems; i++) {
            int price = scanner.nextInt();
            int quantity = scanner.nextInt();
            calculatedTotal += price * quantity;
        }
        
        // Check if the calculated total matches the total amount from the receipt
        if (calculatedTotal == totalAmount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        // Close the scanner
        scanner.close();
    }
}
