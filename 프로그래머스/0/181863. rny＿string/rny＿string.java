class Solution {
    public String solution(String rny_string) {
        // 문자열을 StringBuilder로 변환하여 수정 가능하도록 합니다.
        StringBuilder sb = new StringBuilder(rny_string);
        
        // 문자열을 순회하면서 'm'을 'rn'으로 대체합니다.
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'm') {
                sb.replace(i, i + 1, "rn");
                // 'm'을 'rn'으로 대체했으므로 인덱스를 한 칸 뒤로 이동합니다.
                i++;
            }
        }
        
        // StringBuilder를 다시 String으로 변환하여 반환합니다.
        return sb.toString();
    }
}
