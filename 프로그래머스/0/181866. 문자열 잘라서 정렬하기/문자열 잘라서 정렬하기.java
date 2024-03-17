import java.util.*;

class Solution {
    public String[] solution(String myString) {
        StringTokenizer st = new StringTokenizer(myString, "x");
        int idx = 0, N = st.countTokens();
        String[] result = new String[N];
        
        for (int n = 0;n < N;n++)
            result[idx++] = st.nextToken();
        
        Arrays.sort(result);
        return result;
    }
}