class Solution {
    public int solution(String message) {
        int length = message.length();
        int paperWidth = length * 2; // 각 글자를 2cm 크기로 적으므로 글자 수에 2를 곱합니다.
        return paperWidth;
    }
}
