import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 공백을 기준으로 문자열을 분리하여 배열에 저장
        String[] split = s.split(" ");
        // 숫자들을 저장하기 위한 스택 생성
        Stack<Integer> stack = new Stack<>();
        
        for (String item : split) {
            if (item.equals("Z")) {
                // "Z"가 나오면 스택에서 마지막 숫자 제거
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // 숫자를 스택에 추가
                int num = Integer.parseInt(item);
                stack.push(num);
            }
        }
        
        // 스택에 남은 숫자들을 모두 더함
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}
