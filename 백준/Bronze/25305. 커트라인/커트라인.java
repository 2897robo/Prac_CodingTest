import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        Integer[] a = new Integer[n]; // Integer 배열 사용
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 내림차순으로 정렬
        Arrays.sort(a, Collections.reverseOrder());

        // k-1 인덱스의 값 출력
        System.out.println(a[k - 1]);
    }
}
