public class Solution {
    public int solution(int n) {
        // n명이 먹을 수 있는 피자의 최소 판 수를 구한다.
        int answer = 1; // 최소 한 판은 필요하므로 1부터 시작
        while(true) {
            // 6조각씩 나눠진 피자를 n명이 나눠먹을 때, 모두 같은 수의 조각을 먹으려면
            // 6 * answer (피자 판 수 * 조각 수)가 n명으로 나누어 떨어져야 한다.
            if ((6 * answer) % n == 0) {
                break; // 나누어 떨어지면 반복 종료
            }
            answer++; // 나누어 떨어지지 않으면 판 수를 1증가
        }
        return answer; // 계산된 최소 피자 판 수 반환
    }
}
