class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean b = true;
        for(char c : s.toCharArray()) {
            if(b && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                b = false;
            } else if(!b && Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                b = true;
            } else if(c == ' ') {
                sb.append(c);
                b = true;
            }
        }
        return sb.toString();
    }
}