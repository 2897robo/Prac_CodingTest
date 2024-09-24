class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;   //arr1의 행
        int c1 = arr1[0].length;    // arr1의 열
        int r2 = arr2.length;   // arr2의 행
        int c2 = arr2[0].length;    // arr2의 열
        
        int[][] answer = new int[r1][c2];   // arr1의 행 x arr2의 열
        
        for(int i=0; i<r1; i++) {   // arr1의 각 행
            for(int j=0; j<c2; j++) {   // arr2의 각 열
                for(int k=0; k<c1; k++) {       // arr1의 각 열 또는 arr2의 각 행에 대해 반복
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}