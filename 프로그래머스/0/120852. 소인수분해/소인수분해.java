import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n) {
        Set<Integer> primeFactors = new LinkedHashSet<>();
        
        for (int divisor = 2; n > 1; divisor++) {
            while (n % divisor == 0) {
                primeFactors.add(divisor);
                n /= divisor;
            }
        }
        
        // Set을 배열로 변환
        int[] answer = new int[primeFactors.size()];
        int index = 0;
        for (int factor : primeFactors) {
            answer[index++] = factor;
        }
        
        return answer;
    }
}
