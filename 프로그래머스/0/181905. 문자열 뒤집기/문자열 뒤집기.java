class Solution {
    public String solution(String my_string, int s, int e) {
        char[] tmp = my_string.toCharArray();
        StringBuilder answer = new StringBuilder(my_string.substring(0, s));
        
        for(int i=e; i>=s; i--) {
            char c = tmp[i];
            answer.append(c);
        }
        
        answer.append(my_string.substring(e + 1));
        
        return answer.toString();
    }
}