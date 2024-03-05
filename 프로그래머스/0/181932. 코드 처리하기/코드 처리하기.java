import java.util.*;

class Solution {
    public String solution(String code) {
        char[] codeArr = code.toCharArray();
        int mode = 0;
        StringBuilder ret = new StringBuilder();
        
        for(int i = 0; i < codeArr.length; i++) {
            if(mode == 0) {
                if(codeArr[i] != '1') {
                    if(i % 2 == 0) {
                        ret.append(codeArr[i]);
                    }
                }
                else {
                    mode = 1;
                }
            }
            else if(mode == 1) {
                if(codeArr[i] != '1') {
                    if(i % 2 == 1) {
                        ret.append(codeArr[i]);
                    }
                }
                else {
                    mode = 0;
                }
            }
        }
        
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}
