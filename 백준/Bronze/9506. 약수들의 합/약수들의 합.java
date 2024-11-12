import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        while(true) {
            n = sc.nextInt();
            if(n == -1) {
                break;
            }

            for(int i=1; i<n; i++) {
                if(n%i==0) {
                    list.add(i);
                    sum += i;
                }
            }

            if(sum == n) {
                System.out.print(n + " = ");
                for(int i=0; i<list.size(); i++) {
                    System.out.print(list.get(i));
                    if(i<list.size() - 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.println();
                sum = 0;
                list.clear();
            } else {
                System.out.println(n + " is NOT perfect.");
                sum = 0;
                list.clear();
            }
        }
    }
}