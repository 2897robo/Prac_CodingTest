class Solution {
    public int solution(int[] numbers) {
        int max1 = 0;  // To store the largest number
        int max2 = 0;  // To store the second largest number
        
        for (int num : numbers) {
            if (num > max1) {
                max2 = max1; // Update second largest
                max1 = num;  // Update largest
            } else if (num > max2) {
                max2 = num; // Update second largest only if current num is not larger than max1 but is larger than max2
            }
        }
        
        return max1 * max2; // Return the product of the two largest numbers
    }
}
