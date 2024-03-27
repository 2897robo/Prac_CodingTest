import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // 배열에 있는 숫자들의 빈도수를 계산합니다.
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int maxCount = 0;
        int mode = -1;
        boolean isMultipleModes = false;
        
        // 빈도수가 가장 큰 값을 찾습니다.
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int currentCount = entry.getValue();
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mode = entry.getKey();
                isMultipleModes = false;
            } else if (currentCount == maxCount) {
                isMultipleModes = true;
            }
        }
        
        // 최빈값이 여러 개인 경우 -1을 반환합니다.
        if (isMultipleModes) {
            return -1;
        }
        
        return mode;
    }
}
