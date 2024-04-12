class Solution {
    public static int solution(int[] numbers, int k) {
        int n = numbers.length;
        int currentIndex = 0;  // 공을 처음 던지는 사람의 인덱스
        
        // k번 공을 던질 때까지 반복
        for (int i = 1; i < k; i++) {
            // 현재 인덱스에서 오른쪽으로 2칸 이동
            currentIndex = (currentIndex + 2) % n;
        }
        
        // k번째로 공을 던진 사람의 번호 반환
        return numbers[currentIndex];
    }
}