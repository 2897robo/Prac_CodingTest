class Solution {
    public int solution(String binomial) {
        // 이항식을 공백을 기준으로 나눕니다.
        String[] parts = binomial.split(" ");
        
        // 나눠진 부분을 숫자와 연산자로 분리합니다.
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char op = parts[1].charAt(0);
        
        // 연산자에 따라 계산합니다.
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
        }
        
        return result;
    }
}
