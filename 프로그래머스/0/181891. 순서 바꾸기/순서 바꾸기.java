import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> tmp = new ArrayList<> ();
        for(int i=n; i<num_list.length; i++) {
            tmp.add(num_list[i]);
        }
        for(int i=0; i<n; i++) {
            tmp.add(num_list[i]);
        }
        
        int[] answer = new int[tmp.size()];
        for(int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}