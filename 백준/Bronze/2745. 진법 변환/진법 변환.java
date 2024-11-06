import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10); map.put('B', 11); map.put('C', 12); map.put('D', 13); map.put('E', 14); map.put('F', 15); map.put('G', 16);
        map.put('H', 17); map.put('I', 18); map.put('J', 19); map.put('K', 20); map.put('L', 21); map.put('M', 22); map.put('N', 23);
        map.put('O', 24); map.put('P', 25); map.put('Q', 26); map.put('R', 27); map.put('S', 28); map.put('T', 29); map.put('U', 30);
        map.put('V', 31); map.put('W', 32); map.put('X', 33); map.put('Y', 34); map.put('Z', 35);

        for(int i=0; i<n.length(); i++) {
            char c = n.charAt(i);
            int value;

            if(map.containsKey(c)) {
                value = map.get(c);
            } else {
                value = Character.getNumericValue(c);
            }

            answer += value * Math.pow(b, n.length() - 1 - i);
        }

        System.out.print(answer);
    }
}