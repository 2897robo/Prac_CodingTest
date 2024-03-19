class Solution {
    public int solution(String num_str) {
        long answer = 0; // 누적 변수의 자료형을 long으로 변경
        for(int i = 0; i < num_str.length(); i++) {
            char digit = num_str.charAt(i);
            if(Character.isDigit(digit)) { // 숫자 문자인 경우에만 처리
                answer += Character.getNumericValue(digit);
            }
        }
        return (int)answer; // long을 int로 변환하여 반환
    }
}
