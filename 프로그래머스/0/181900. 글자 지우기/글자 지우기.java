import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        
        Arrays.sort(indices);
        
        for(int i:indices) {
            answer.append(my_string.substring(idx, i));
            idx = i+1;
        }
        
        answer.append(my_string.substring(idx));
        
        return answer.toString();
    }
}