import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        sc.close();
        int A[] = new int[n.length()];
        for(int i=0; i<n.length(); i++) {
            A[i] = Integer.parseInt(n.substring(i, i+1));
        }

        // 선택정렬
        for(int i=0; i<n.length(); i++) {
            int max = i;
            for(int j=i+1; j<n.length(); j++) {
                if(A[j] > A[max]) {
                    max = j;
                }
            }

            if(A[i] < A[max]) {
                int tmp = A[i];
                A[i] = A[max];
                A[max] = tmp;
            }
        }

        for(int i : A) {
            System.out.print(i);
        }
    }
}