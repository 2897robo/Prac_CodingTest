class Solution {
    public int solution(int n) {
        if(n < 2) return n;
       int answer = 2; // 1과 자기자신
        for(int i=2; i<Math.sqrt(n+1); i++){
            if(n % i == 0){
                answer += i == n / i ? 1 : 2;
            }
        }
        return answer;
    }
}