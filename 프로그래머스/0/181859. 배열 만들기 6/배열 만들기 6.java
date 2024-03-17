import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> tmp = new ArrayList<> ();
        for(int i=0; i<arr.length; i++) {
            if(tmp.isEmpty()) {
                tmp.add(arr[i]);
            }
            else if((!tmp.isEmpty()) && (tmp.get(tmp.size()-1) == arr[i])) {
                tmp.remove(tmp.size()-1);
            }
            else if((!tmp.isEmpty()) && (tmp.get(tmp.size()-1) != arr[i])) {
                tmp.add(arr[i]);
            }
        }
        
        int[] answer;
        if(tmp.isEmpty()) {
            answer = new int[]{-1};
        } else {
            answer = new int[tmp.size()];
            for(int i = 0; i < tmp.size(); i++) {
                answer[i] = tmp.get(i);
            }
        }
        
        return answer;
    }
}