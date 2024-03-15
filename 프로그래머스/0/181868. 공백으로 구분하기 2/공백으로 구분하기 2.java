import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] tmp = my_string.trim().split(" ");
        List<String> arr = new ArrayList<> ();
        
        for(String i:tmp) {
            if(!(i.equals(""))) {
                arr.add(i);
            }
        }
        
        String[] answer = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}