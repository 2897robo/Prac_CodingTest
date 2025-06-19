import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<> ();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(char type : types) {
            scores.put(type, 0);
        }
        
        for(int i=0; i<survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];
            
            if(choice < 4) {
                scores.put(disagree, scores.get(disagree) + (4 - choice));
            } else if(choice > 4) {
                scores.put(agree, scores.get(agree) + (choice - 4));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(scores.get('R') >= scores.get('T') ? 'R' : 'T');
        sb.append(scores.get('C') >= scores.get('F') ? 'C' : 'F');
        sb.append(scores.get('J') >= scores.get('M') ? 'J' : 'M');
        sb.append(scores.get('A') >= scores.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}
