import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        Map<Integer, int[]> pos = new HashMap<>();
        int[][] map = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-2}
        };
        
        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                pos.put(map[i][j], new int[]{i, j});
            }
        }
        
        int[] left = pos.get(-1); // '*'
        int[] right = pos.get(-2); // '#'

        for(int num : numbers) {
            int[] target = pos.get(num);
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = target;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = target;
            } else {
                int lDist = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int rDist = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
                if (lDist < rDist) {
                    sb.append("L");
                    left = target;
                } else if (rDist < lDist) {
                    sb.append("R");
                    right = target;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = target;
                    } else {
                        sb.append("R");
                        right = target;
                    }
                }
            }
        }

        return sb.toString();
    }
}