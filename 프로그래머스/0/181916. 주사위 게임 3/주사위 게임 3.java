class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] count = new int[7]; // 주사위 눈의 개수를 저장할 배열

        // 주사위 눈의 개수를 count 배열에 저장
        count[a]++;
        count[b]++;
        count[c]++;
        count[d]++;

        int maxCount = 0; // 가장 많이 나온 눈의 개수
        int maxNum = 0; // 가장 많이 나온 눈의 값

        // 주사위 눈의 개수를 확인하여 최댓값 찾기
        for (int i = 1; i <= 6; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxNum = i;
            }
        }

        int score = 0; // 점수 초기화

        // 모든 주사위 눈이 같은 경우
        if (maxCount == 4) {
            score = 1111 * maxNum;
        }
        // 세 주사위가 같은 숫자인 경우
        else if (maxCount == 3) {
            for (int i = 1; i <= 6; i++) {
                if (count[i] == 1) {
                    score = (10 * maxNum + i) * (10 * maxNum + i);
                    break;
                }
            }
        }
        // 두 쌍의 주사위 눈이 같은 경우
        else if (maxCount == 2) {
            int p = 0, q = 0, r = 0; // 두 쌍의 숫자
            int pairCount = 0; // 같은 숫자의 쌍의 개수
            for (int i = 1; i <= 6; i++) {
                if (count[i] == 2) {
                    pairCount++;
                }
            }
            // 두 쌍의 숫자가 있을 경우
            if (pairCount == 2) {
                for (int i = 1; i <= 6; i++) {
                    if (count[i] == 2) {
                        if (p == 0) {
                            p = i;
                        } else {
                            q = i;
                            score = (p+q) * Math.abs(p-q);
                            break;
                        }
                    }
                }
            }
            // 한 쌍의 숫자만 있을 경우
            else {
                for (int i = 1; i <= 6; i++) {
                    if (count[i] == 1) {
                        if (r == 0) {
                            r = i;
                        } else {
                            q = i;
                            score = q * r;
                            break;
                        }
                    }
                }
            }
        }
        // 모든 주사위 눈이 다른 경우
        else {
            int minNum = 7; // 가장 작은 숫자
            for (int i = 1; i <= 6; i++) {
                if (count[i] == 1 && i < minNum) {
                    minNum = i;
                }
            }
            score = minNum;
        }

        return score;
    }
}
