import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int a=0; a<answer.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] tmp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(tmp);
            answer[a] = tmp[k-1];
        }
        
        return answer;
    }
}