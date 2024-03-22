class Solution {
    public int solution(int[][] arr) {
        int n = arr.length;
        
        // 이차원 배열의 모든 원소에 대해 i, j에 대해 arr[i][j]와 arr[j][i]가 같은지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0; // 조건을 만족하지 않으면 0 반환
                }
            }
        }
        
        // 모든 조건을 만족하면 1 반환
        return 1;
    }
}
