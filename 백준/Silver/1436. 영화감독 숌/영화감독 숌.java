import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // N번째 영화 제목을 구할 것
        int count = 0;         // 찾은 종말의 수 개수를 셀 변수
        int num = 666;         // 첫 번째 종말의 수는 666

        // N번째 종말의 수를 찾을 때까지 반복
        while (true) {
            if (String.valueOf(num).contains("666")) {  // 숫자가 "666"을 포함하면
                count++;
            }
            if (count == N) {
                System.out.println(num);  // N번째 종말의 수를 출력
                break;
            }
            num++;  // 다음 숫자 탐색
        }
    }
}
