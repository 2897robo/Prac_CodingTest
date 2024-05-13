class Solution {
    public int solution(int[] array, int n) {
        int minDiff = Integer.MAX_VALUE;
        int closestNumber = 0;

        for (int num : array) {
            int diff = Math.abs(num - n);
            if (diff < minDiff || (diff == minDiff && num < closestNumber)) {
                minDiff = diff;
                closestNumber = num;
            }
        }

        return closestNumber;
    }
}
