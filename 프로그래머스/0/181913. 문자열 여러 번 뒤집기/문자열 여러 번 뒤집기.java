class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] charArray = my_string.toCharArray();
        
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            
            // start부터 end까지의 문자열을 뒤집기
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        
        return new String(charArray);
    }
}
