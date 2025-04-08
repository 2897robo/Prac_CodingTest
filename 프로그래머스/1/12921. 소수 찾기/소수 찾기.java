class Solution {
    public int solution(int n) {
        boolean[] notPrime = new boolean[n+1];
        notPrime[0] = true; notPrime[1] = true;
        
        for(int i=2; i*i<=n; i++) {
            if(!notPrime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    notPrime[j] = true;
                }
            }
        }
        
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(!notPrime[i]) answer++;
        }
        
        return answer;
    }
}