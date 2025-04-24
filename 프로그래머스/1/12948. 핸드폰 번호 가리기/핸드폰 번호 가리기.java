class Solution {
    public String solution(String phone_number) {
        int l = phone_number.length()-4;
        String answer = "*".repeat(l);
        answer += phone_number.substring(l);
        return answer;
    }
}