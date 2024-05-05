class Solution {
    public int solution(String my_string) {
        int answer = 0;
        // 문자열을 순회합니다.
        for(int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            // 해당 문자가 숫자인지 확인합니다.
            if(Character.isDigit(c)) {
                // 숫자라면 그 값을 정수로 변환하여 answer에 더합니다.
                answer += Character.getNumericValue(c);
            }
        }
        return answer;
    }
}
