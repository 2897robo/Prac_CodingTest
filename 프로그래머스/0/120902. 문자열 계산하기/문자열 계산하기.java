class Solution {
    public int solution(String my_string) {
        // 주어진 수식에서 숫자와 연산자를 분리하여 배열에 저장
        String[] elements = my_string.split(" ");
        
        // 첫 번째 숫자를 결과값으로 초기화
        int result = Integer.parseInt(elements[0]);
        
        // 순회하면서 연산 수행
        for (int i = 1; i < elements.length; i += 2) {
            String operator = elements[i];
            int operand = Integer.parseInt(elements[i + 1]);
            
            if (operator.equals("+")) {
                result += operand;
            } else if (operator.equals("-")) {
                result -= operand;
            }
        }
        
        return result;
    }
}
