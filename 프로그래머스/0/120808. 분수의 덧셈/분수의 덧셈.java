public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 두 분수를 더한 분자와 분모를 계산합니다.
        int newNumer = numer1 * denom2 + numer2 * denom1;
        int newDenom = denom1 * denom2;
        
        // 결과 분수를 기약 분수로 만듭니다.
        int gcd = gcd(newNumer, newDenom);
        newNumer /= gcd;
        newDenom /= gcd;
        
        return new int[]{newNumer, newDenom};
    }
    
    // 최대공약수를 구하는 메서드
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
