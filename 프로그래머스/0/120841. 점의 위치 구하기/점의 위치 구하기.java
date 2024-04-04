class Solution {
    public int solution(int[] dot) {
        // x좌표와 y좌표를 dot 배열에서 추출합니다.
        int x = dot[0];
        int y = dot[1];
        
        // x와 y 좌표의 값을 기반으로 사분면을 판단합니다.
        if(x > 0 && y > 0) {
            // x, y 모두 양수인 경우 제1사분면
            return 1;
        } else if(x < 0 && y > 0) {
            // x는 음수, y는 양수인 경우 제2사분면
            return 2;
        } else if(x < 0 && y < 0) {
            // x, y 모두 음수인 경우 제3사분면
            return 3;
        } else {
            // x는 양수, y는 음수인 경우 제4사분면
            return 4;
        }
    }
}