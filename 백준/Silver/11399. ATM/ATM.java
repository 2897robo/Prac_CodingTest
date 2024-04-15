import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        // 삽입 정렬 시작
        for(int i=1; i<n; i++) {
            int current = a[i];
            int j = i-1;
            while(j>=0 && a[j] > current) {
                a[j+1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }

        // 최소 대기 시간 합계
        int totalWait = 0;
        int sum = 0;
        for(int i : a) {
            sum += i;
            totalWait += sum;
        }

        System.out.println(totalWait);
    }
}