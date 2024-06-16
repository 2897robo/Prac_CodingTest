class Solution {
    public String[] solution(String my_str, int n) {
        // 자를 문자열의 총 개수 계산
        int length = my_str.length();
        int arraySize = (int) Math.ceil((double) length / n);
        
        // 결과를 저장할 배열 선언
        String[] answer = new String[arraySize];
        
        // 문자열을 n 길이씩 자르기
        for (int i = 0; i < arraySize; i++) {
            int start = i * n;
            int end = Math.min(start + n, length); // 문자열의 끝을 넘지 않도록 설정
            answer[i] = my_str.substring(start, end);
        }
        
        return answer;
    }
}
