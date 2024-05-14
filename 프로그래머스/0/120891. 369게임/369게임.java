class Solution {
    public int solution(int order) {
        // 정답을 저장할 변수
        int answer = 0;
        // 주어진 숫자를 문자열로 변환
        String orderStr = String.valueOf(order);
        
        // 각 자리 숫자를 확인하면서 3, 6, 9가 있는지 확인
        for (int i = 0; i < orderStr.length(); i++) {
            char digit = orderStr.charAt(i);
            // 숫자가 3, 6, 9 중 하나이면 박수 횟수를 증가시킴
            if (digit == '3' || digit == '6' || digit == '9') {
                answer++;
            }
        }
        
        // 최종 박수 횟수 반환
        return answer;
    }
}
