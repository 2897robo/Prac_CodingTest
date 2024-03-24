class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1}; // 최고의 집합이 존재하지 않는 경우
        
        int[] answer = new int[n];
        int base = s / n; // 기본값
        int remainder = s % n; // 나머지
        
        // 기본값으로 배열 초기화
        for (int i = 0; i < n; i++) {
            answer[i] = base;
        }
        
        // 나머지를 배열의 마지막부터 분배
        for (int i = n - 1; i >= n - remainder; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}
