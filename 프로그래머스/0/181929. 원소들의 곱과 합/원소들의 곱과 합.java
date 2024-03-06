class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        for(int i:num_list) {
            mul = mul*i;
            sum = sum+i;
        }
        
        return (Math.pow(sum,2)<mul) ? 0:1;
    }
}