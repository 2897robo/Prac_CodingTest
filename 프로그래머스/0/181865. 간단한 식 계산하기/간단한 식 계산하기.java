class Solution {
    public int solution(String binomial) {
        String[] tmp = binomial.split(" ");
        int answer = 0;
        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[2]);
        
        switch(tmp[1]) {
            case "+":
                answer = a+b;
                break;
            case "-":
                answer = a-b;
                break;
            case "*":
                answer = a*b;
                break;
        }
        
        return answer;
    }
}