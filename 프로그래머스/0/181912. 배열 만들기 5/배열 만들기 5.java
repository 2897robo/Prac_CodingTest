import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer_list = new ArrayList<Integer> ();
        
        for(int i=0; i<intStrs.length; i++) {
            String tmp = intStrs[i].substring(s, s+l);
            int temp_int = Integer.parseInt(tmp);
            if(temp_int > k) {
                answer_list.add(temp_int);
            }
        }
        
        int[] answer = new int[answer_list.size()];
        for(int i=0; i<answer_list.size(); i++) {
            answer[i] = answer_list.get(i);
        }
        
        return answer;
    }
}