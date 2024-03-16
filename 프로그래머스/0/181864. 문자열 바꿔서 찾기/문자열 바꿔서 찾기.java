class Solution {
    public int solution(String myString, String pat) {
        // 문자열 myString의 "A"를 임시 문자로 대체한 후 "B"를 "A"로 변경하여 새로운 문자열을 만듭니다.
        String modifiedString = myString.replace('A', '_').replace('B', 'A').replace('_', 'B');
        
        // 변경된 문자열에서 pat이 존재하는지 확인합니다.
        return modifiedString.contains(pat) ? 1 : 0;
    }
}
