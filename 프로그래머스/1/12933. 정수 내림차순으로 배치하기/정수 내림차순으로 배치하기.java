import java.util.*;

class Solution {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }

        return Long.parseLong(sb.toString());
    }
}