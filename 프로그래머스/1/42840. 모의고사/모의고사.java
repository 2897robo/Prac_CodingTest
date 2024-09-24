import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자의 찍는 방식
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 수포자의 맞힌 문제 수를 저장할 배열
        int[] score = new int[3];
        
        // 문제의 답을 비교하며 각 수포자의 정답 개수를 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i % answer1.length]) score[0]++;
            if (answers[i] == answer2[i % answer2.length]) score[1]++;
            if (answers[i] == answer3[i % answer3.length]) score[2]++;
        }

        // 가장 많은 문제를 맞힌 수 구하기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 가장 높은 점수를 받은 수포자(들)를 리스트에 추가
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                result.add(i + 1); // 수포자는 1번부터 시작하므로 i + 1
            }
        }

        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
