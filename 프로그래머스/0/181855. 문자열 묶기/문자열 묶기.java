class Solution {
    public int solution(String[] strArr) {
        int[] arr = new int[101]; // 가장 긴 문자열의 길이는 100을 넘지 않습니다.
        
        for(String str : strArr) {
            arr[str.length()]++;
        }
        
        int maxCount = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                maxCount = Math.max(maxCount, arr[i]);
            }
        }
        
        return maxCount;
    }
}
