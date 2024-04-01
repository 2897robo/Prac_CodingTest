public class Solution {
    public int solution(int n) {
        int count = 0; // 순서쌍의 개수를 저장할 변수
        
        // 1부터 n까지 숫자 중에서 n을 나눌 수 있는 숫자를 찾음
        for (int i = 1; i <= Math.sqrt(n); i++) {
            // n을 i로 나누었을 때 나머지가 0이면 순서쌍을 찾은 것
            if (n % i == 0) {
                // 나누어 떨어지는 경우, 순서쌍이 하나 증가
                count++;
                
                // i와 n/i가 다르면 반대 순서쌍도 존재
                if (i != n / i) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
