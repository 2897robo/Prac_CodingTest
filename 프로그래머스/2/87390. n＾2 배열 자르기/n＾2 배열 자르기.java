class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);  // 구할 배열의 크기
        int[] answer = new int[size];  // 결과 배열
        
        int idx = 0;
        for (long k = left; k <= right; k++) {
            int i = (int)(k / n);  // 행
            int j = (int)(k % n);  // 열
            answer[idx++] = Math.max(i, j) + 1;
        }
        
        return answer;
    }
}
