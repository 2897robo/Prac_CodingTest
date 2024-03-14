class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int sec = 0;
        int answer = 0;
        for(int i=0; i<num_list.length; i++) {
            if(i%2==0) {
                sec += num_list[i];
            }
            else {
                odd += num_list[i];
            }
        }
        
        answer = sec>odd ? sec:odd;
        return answer;
    }
}