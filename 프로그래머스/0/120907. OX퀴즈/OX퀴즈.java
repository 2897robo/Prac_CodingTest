import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" "); // 공백을 기준으로 문자열 분리
            
            int x = Integer.parseInt(parts[0]); // X 값
            int y = Integer.parseInt(parts[2]); // Y 값
            int z = Integer.parseInt(parts[4]); // Z 값
            String operator = parts[1]; // 연산자
            
            int result = 0;
            if (operator.equals("+")) {
                result = x + y;
            } else if (operator.equals("-")) {
                result = x - y;
            }
            
            if (result == z) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        
        return answer;
    }
}
