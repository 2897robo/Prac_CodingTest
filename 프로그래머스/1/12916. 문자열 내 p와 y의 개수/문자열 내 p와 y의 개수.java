class Solution {
    boolean solution(String s) {
        int i=0, j=0;
        for(int a=0; a<s.length(); a++) {
            if(s.toLowerCase().charAt(a) == 'p') {
                i++;
            } else if(s.toLowerCase().charAt(a) == 'y') {
                j++;
            }
        }
        
        if(i==j) {
            return true;
        } else {
            return false;
        }
    }
}