class Solution {
    public int solution(int[] box, int n) {
        // box 배열에서 각 차원을 n으로 나누어서 그 결과를 곱합니다.
        int width = box[0] / n;  // 가로 차원에서 들어갈 수 있는 주사위의 개수
        int height = box[1] / n; // 세로 차원에서 들어갈 수 있는 주사위의 개수
        int depth = box[2] / n;  // 높이 차원에서 들어갈 수 있는 주사위의 개수
        
        // 위에서 구한 세 값의 곱을 반환합니다.
        return width * height * depth;
    }
}