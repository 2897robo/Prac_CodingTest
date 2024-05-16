class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : my_string.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            }
        }
        
        return result.toString();
    }
}
