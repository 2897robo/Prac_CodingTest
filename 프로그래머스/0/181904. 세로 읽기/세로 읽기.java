class Solution {
    public String solution(String my_string, int m, int c) {
        char[][] tmp = new char[my_string.length()/m][m];
        for(int i=0; i<tmp.length; i++) {
            for(int j=0; j<m; j++) {
                tmp[i][j] = my_string.charAt(i*m + j);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<tmp.length; i++) {
            answer.append(tmp[i][c-1]);
        }
        
        return answer.toString();
    }
}