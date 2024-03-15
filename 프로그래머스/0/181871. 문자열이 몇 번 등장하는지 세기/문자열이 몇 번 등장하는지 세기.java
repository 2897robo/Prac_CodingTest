class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patLength = pat.length();
        int strLength = myString.length();
        
        // 주어진 문자열의 각 위치에서 패턴을 검사합니다.
        for (int i = 0; i <= strLength - patLength; i++) {
            String substr = myString.substring(i, i + patLength);
            if (substr.equals(pat)) {
                answer++;
            }
        }
        
        return answer;
    }
}
