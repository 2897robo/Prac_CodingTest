import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> tmp = new ArrayList<> ();
        for(int i=0; i<todo_list.length; i++) {
            if(!finished[i]) {
                tmp.add(todo_list[i]);
            }
        }
        
        String[] answer = new String[tmp.size()];
        for(int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}