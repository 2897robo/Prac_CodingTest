class Solution {
    public String solution(int[] numLog) {
        StringBuilder tmp = new StringBuilder();
        
        for(int i=1; i<numLog.length; i++) {
            switch(numLog[i]-numLog[i-1]) {
                case 1:
                    tmp.append("w");
                    break;
                case -1:
                    tmp.append("s");
                    break;
                case 10:
                    tmp.append("d");
                    break;
                case -10:
                    tmp.append("a");
                    break;
            }
        }
        
        return tmp.toString();
    }
}