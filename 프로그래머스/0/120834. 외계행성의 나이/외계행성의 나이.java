public class Solution {
    public String solution(int age) {
        StringBuilder ageInLetters = new StringBuilder();
        String ageStr = String.valueOf(age);
        for (char digit : ageStr.toCharArray()) {
            // '0'에서 '9'까지의 숫자를 'a'에서 'j'까지의 알파벳으로 매핑
            char letter = (char) ('a' + (digit - '0'));
            ageInLetters.append(letter);
        }
        
        return ageInLetters.toString();
    }
}
