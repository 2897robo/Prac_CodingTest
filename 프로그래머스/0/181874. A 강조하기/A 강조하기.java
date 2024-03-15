class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder(myString.toLowerCase());
        
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == 'a') {
                answer.setCharAt(i, Character.toUpperCase('a'));
            }
        }
        
        return answer.toString();
    }
}