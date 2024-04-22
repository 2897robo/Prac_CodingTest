public class Solution {
    public int solution(int n) {
        int count = 0; // 합성수의 개수를 저장할 변수

        for (int i = 2; i <= n; i++) { // 1은 합성수가 아니므로 2부터 시작
            if (isComposite(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isComposite(int number) {
        int divisorCount = 0; // 약수의 개수를 계산할 변수

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) { // 나누어 떨어지면 약수
                divisorCount++;
            }
        }

        // 약수가 3개 이상이면 합성수
        return divisorCount > 2;
    }
}
