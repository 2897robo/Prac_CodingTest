class Solution {
    public int solution(int[][] dots) {
        // x 좌표의 최소값과 최대값 찾기
        int minX = dots[0][0];
        int maxX = dots[0][0];
        // y 좌표의 최소값과 최대값 찾기
        int minY = dots[0][1];
        int maxY = dots[0][1];
        
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][0] < minX) {
                minX = dots[i][0];
            }
            if (dots[i][0] > maxX) {
                maxX = dots[i][0];
            }
            if (dots[i][1] < minY) {
                minY = dots[i][1];
            }
            if (dots[i][1] > maxY) {
                maxY = dots[i][1];
            }
        }
        
        // 가로와 세로 길이 계산
        int width = maxX - minX;
        int height = maxY - minY;
        
        // 넓이 계산
        return width * height;
    }
}
