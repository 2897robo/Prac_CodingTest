class Solution {
    int count = 0;
    
    public int solution(int[] nums) {
        backtrack(nums, 0, 0, 0);
        return count;
    }
    
    private void backtrack(int[] nums, int start, int depth, int sum) {
        if(depth==3) {
            if(isPrime(sum)) count++;
            return;
        }
        
        for(int i=start; i<nums.length; i++) {
            backtrack(nums, i+1, depth+1, sum+nums[i]);
        }
    }
    
    private boolean isPrime(int num) {
        if(num<2) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}
