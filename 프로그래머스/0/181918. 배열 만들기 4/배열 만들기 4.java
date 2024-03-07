import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> tmp = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++) {
            if(tmp.size() == 0 || tmp.get(tmp.size() - 1) < arr[i]) {
                tmp.add(arr[i]);
            } else {
                while(tmp.size() > 0 && tmp.get(tmp.size() - 1) >= arr[i]) {
                    tmp.remove(tmp.size() - 1);
                }
                tmp.add(arr[i]);
            }
        }
        
        int[] stk = new int[tmp.size()];
        
        for(int i = 0; i < tmp.size(); i++) {
            stk[i] = tmp.get(i);
        }
        
        return stk;
    }
}
