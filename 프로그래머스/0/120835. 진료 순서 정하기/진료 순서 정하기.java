import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[] emergency) {
        // 원래 배열의 복사본을 만들어 정렬
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);
        
        // 응급도에 따른 순위를 저장할 맵 생성
        Map<Integer, Integer> rankMap = new HashMap<>();
        
        // 정렬된 배열을 역순으로 순회하면서 각 응급도의 순위를 맵에 저장
        for (int i = sorted.length - 1; i >= 0; i--) {
            rankMap.put(sorted[i], sorted.length - i);
        }
        
        // 결과를 저장할 배열 생성
        int[] answer = new int[emergency.length];
        
        // 원래 배열의 각 응급도에 해당하는 순위를 결과 배열에 저장
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = rankMap.get(emergency[i]);
        }
        
        return answer;
    }
}
