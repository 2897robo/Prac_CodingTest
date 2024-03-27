import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            if(i % 2 == 1) {
                arr.add(i);
            }
        }
        
        // List를 int[] 배열로 변환합니다.
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        
        return result;
    }
}
