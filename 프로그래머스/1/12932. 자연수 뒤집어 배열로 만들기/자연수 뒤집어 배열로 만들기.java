import java.util.*;

class Solution {
    public int[] solution(long n) {
        int length = String.valueOf(n).length(); // n의 길이를 구합니다.
        int[] answer = new int[length]; // 길이에 맞게 배열을 생성합니다.
        
        int i = 0; // 인덱스를 배열의 마지막으로 초기화합니다.
        
        while(n > 0) {
            answer[i] = (int)(n % 10); // 마지막 자리수를 배열에 저장합니다.
            n = n / 10; // n을 10으로 나눕니다.
            i++; // 인덱스를 감소시킵니다.
        }
        
        return answer; // 배열을 반환합니다.
    }
}
