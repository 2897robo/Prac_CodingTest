import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // 배열을 순회하며 divisor로 나누어 떨어지는 값들을 Stream으로 필터링하고, 정렬 후 배열로 변환
        int[] answer = Arrays.stream(arr)
                             .filter(i -> i % divisor == 0)  // 나누어 떨어지는 값 필터링
                             .sorted()                       // 정렬
                             .toArray();                     // 배열로 변환
        
        // 나누어 떨어지는 값이 없는 경우 -1 반환
        if (answer.length == 0) {
            return new int[]{-1};
        } else {
            return answer;
        }
    }
}
