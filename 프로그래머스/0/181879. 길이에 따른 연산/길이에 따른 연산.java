class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 1;
        for(int i:num_list) {
            if(num_list.length >= 11) {
                answer += i;
            }
            else {
                sum *= i;
            }
        }
        
        return num_list.length>=11 ? answer:sum;
    }
}