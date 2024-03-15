import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> tmp = new ArrayList<> ();
        
        for(String i : strArr) {
            if(i.indexOf("ad") == -1) {
                tmp.add(i);
            }
        }
        
        String[] answer = new String[tmp.size()];
        for(int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}