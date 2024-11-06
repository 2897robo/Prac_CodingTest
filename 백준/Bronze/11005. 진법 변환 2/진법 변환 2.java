import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A"); map.put(11, "B"); map.put(12, "C"); map.put(13, "D"); map.put(14, "E"); map.put(15, "F"); map.put(16, "G");
        map.put(17, "H"); map.put(18, "I"); map.put(19, "J"); map.put(20, "K"); map.put(21, "L"); map.put(22, "M"); map.put(23, "N");
        map.put(24, "O"); map.put(25, "P"); map.put(26, "Q"); map.put(27, "R"); map.put(28, "S"); map.put(29, "T"); map.put(30, "U");
        map.put(31, "V"); map.put(32, "W"); map.put(33, "X"); map.put(34, "Y"); map.put(35, "Z");

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n%b >= 10) {
                sb.append(map.get(n%b));
            } else {
                sb.append(n%b);
            }
            n = n/b;
        }

        System.out.print(sb.reverse());
    }
}