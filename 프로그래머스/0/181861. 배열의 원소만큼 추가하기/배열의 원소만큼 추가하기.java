import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> tmp = new ArrayList<> ();
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i]; j++) {
                tmp.add(arr[i]);
            }
        }
        
        answer = new int[tmp.size()];
        
        for(int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}