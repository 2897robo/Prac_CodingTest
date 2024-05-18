class Solution {
    public String solution(String my_string, int num1, int num2) {
        // 문자열을 char 배열로 변환
        char[] chars = my_string.toCharArray();
        
        // num1과 num2 위치의 문자를 서로 교환
        char temp = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = temp;
        
        // 변경된 char 배열을 다시 문자열로 변환하여 반환
        return new String(chars);
    }
}
