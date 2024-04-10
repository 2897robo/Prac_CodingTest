import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        sc.close();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<N; i++) {
            int current = A[i];
            // 필요한 숫자까지 push
            while(num <= current) {
                stack.push(num++);
                sb.append("+\n");
            }
            // 스택의 top이 현재 숫자와 다르면 수열을 만들 수 없음
            if(stack.peek() != current) {
                System.out.println("NO");
                result = false;
                break;
            }
            // 스택의 top이 현재 숫자와 같으면 pop
            stack.pop();
            sb.append("-\n");
        }

        if(result) {
            System.out.println(sb.toString());
        }
    }
}