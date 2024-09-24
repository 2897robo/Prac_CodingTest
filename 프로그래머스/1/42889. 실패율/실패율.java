class Solution {
    public int[] solution(int N, int[] stages) {
        double[] failure = new double[N]; // 실패율 저장 배열
        int totalPlayers = stages.length; // 전체 플레이어 수
        
        for (int i = 0; i < N; i++) {
            int unclear = 0; // 스테이지에 도달했지만 통과하지 못한 사람 수

            // 스테이지에 도달했지만 통과하지 못한 사람을 센다.
            for (int stage : stages) {
                if (stage == i + 1) {
                    unclear++;
                }
            }
            
            // 실패율 계산: 분모는 해당 스테이지에 도달한 사람 수 (totalPlayers)
            if (totalPlayers > 0) {
                failure[i] = (double) unclear / totalPlayers;
                totalPlayers -= unclear; // 스테이지를 통과하지 못한 사람을 제외하고 그 다음 스테이지로 진행
            } else {
                failure[i] = 0; // 더 이상 도달한 사람이 없으면 실패율은 0
            }
        }

        // 스테이지 번호와 실패율을 묶어서 정렬하기 위한 배열 생성
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = i + 1; // 스테이지 번호 1부터 저장
        }

        // 실패율을 기준으로 스테이지 번호를 정렬 (내림차순)
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (failure[j] < failure[j + 1]) {
                    // 실패율이 더 높은 스테이지가 앞에 오도록 스왑
                    double tempFail = failure[j];
                    failure[j] = failure[j + 1];
                    failure[j + 1] = tempFail;

                    int tempStage = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = tempStage;
                }
            }
        }

        return answer;
    }
}
