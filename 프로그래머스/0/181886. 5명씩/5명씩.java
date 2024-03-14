import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> tmp = new ArrayList<> ();
        for(int i=0; i<names.length; i+=5) {
            tmp.add(names[i]);
        }
        String[] answer = new String[tmp.size()];
        for(int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}