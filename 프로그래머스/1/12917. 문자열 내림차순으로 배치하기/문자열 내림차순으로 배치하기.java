import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Character[] arr = new Character[s.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(char c : arr) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}