public class Solution {
    public String solution(String my_string) {
        // 문자열을 모두 소문자로 변환
        my_string = my_string.toLowerCase();
        
        // 문자열을 문자 배열로 변환
        char[] chars = my_string.toCharArray();
        
        // 문자 배열을 알파벳 순으로 정렬
        java.util.Arrays.sort(chars);
        
        // 정렬된 문자 배열을 문자열로 변환하여 반환
        return new String(chars);
    }
}
