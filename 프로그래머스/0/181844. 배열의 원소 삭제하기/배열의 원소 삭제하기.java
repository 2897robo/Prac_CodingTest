import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            tmp.add(arr[i]);
        }
        
        for(int i = 0; i < delete_list.length; i++) {
            if(tmp.contains(delete_list[i])) {
                tmp.remove((Integer) delete_list[i]); // 제거할 값이 Integer로 형변환되어야 합니다.
            }
        }
        
        int[] answer = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}
