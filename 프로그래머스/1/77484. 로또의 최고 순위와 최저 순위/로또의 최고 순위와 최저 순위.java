import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;
        Set<Integer> winSet = new HashSet<> ();
        
        for(int num : win_nums) {
            winSet.add(num);
        }
        
        for(int num : lottos) {
            if(num == 0) zeroCount++;
            else if(winSet.contains(num)) matchCount++;
        }
        
        int maxRank = getRank(matchCount + zeroCount);
        int minRank = getRank(matchCount);
        
        return new int[] {maxRank, minRank};
    }
    
    private int getRank(int count) {
        return count >= 2 ? 7-count : 6;
    }
}