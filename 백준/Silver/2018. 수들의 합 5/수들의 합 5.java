import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int count = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

       while(end_idx != n) {
            if(sum == n) {
                count++;
                end_idx++;
                sum = sum + end_idx;
            } else if(sum > n) {
                sum = sum - start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum = sum + end_idx;
            }
       }

       System.out.println(count);
    }
}