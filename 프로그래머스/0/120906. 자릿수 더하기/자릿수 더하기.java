class Solution {
    public int solution(int n) {
        int sum = 0;
        
        // 각 자리 숫자의 합 계산
        while (n > 0) {
            sum += n % 10; // 일의 자리 숫자를 더함
            n /= 10; // 일의 자리 숫자를 제거
        }
        
        return sum;
    }
}
