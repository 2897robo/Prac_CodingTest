class Solution {
    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        char[] arr = numStr.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] - '0' == k) {
                return i+1;
            }
        }
        return -1;
    }
}
