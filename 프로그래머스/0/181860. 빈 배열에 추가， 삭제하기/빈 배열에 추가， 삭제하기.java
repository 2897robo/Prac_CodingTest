import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> tmp = new ArrayList<> ();
        for(int i=0; i<flag.length; i++) {
            if(flag[i]) {
                for(int j=0; j<arr[i]*2; j++) {
                    tmp.add(arr[i]);
                }
            }
            else {
                for(int j=0; j<arr[i]; j++) {
                    tmp.remove(tmp.size()-1);
                }
            }
        }
        
        int[] answer = new int[tmp.size()];
        for(int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}