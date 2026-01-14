import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = 0;
        int n = sc.nextInt();
        int tmp = n;

        //if(n<10) tmp = n*10;

        while(true) {
            n = ((n%10) * 10) + (((n/10) + (n%10)) % 10);
            cycle++;
            
            if(tmp == n) break;
        }

        System.out.println(cycle);

    }
}
