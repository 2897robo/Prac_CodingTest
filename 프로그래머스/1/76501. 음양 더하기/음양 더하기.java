class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<signs.length; i++) {
            int tmp = 0;
            if(signs[i]) tmp += absolutes[i];
            else tmp -= absolutes[i];
            
            answer += tmp;
        }
        return answer;
    }
}