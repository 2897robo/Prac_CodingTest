import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                x=i;
                break;
            }
        }
        
        sb.append("김서방은 ").append(x).append("에 있다");
        return sb.toString();
    }
}