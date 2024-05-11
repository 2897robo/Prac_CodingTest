import java.util.*;

class Solution {
    public int solution(int[] sides) {
        // 세 변을 오름차순으로 정렬
        Arrays.sort(sides);
        
        // 가장 긴 변
        int longest = sides[2];
        // 나머지 두 변의 합
        int sum = sides[0] + sides[1];
        
        // 가장 긴 변의 길이가 나머지 두 변의 합보다 작으면 삼각형이 될 수 있음
        if (longest < sum) {
            return 1;
        } else {
            return 2;
        }
    }
}
