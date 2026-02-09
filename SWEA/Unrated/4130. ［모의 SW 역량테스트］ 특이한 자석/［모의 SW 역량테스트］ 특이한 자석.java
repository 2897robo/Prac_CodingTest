// SWEA - 4130 특이한 자석

import java.io.*;
import java.util.*;

public class Solution {
    
    static final int MAGNET_COUNT = 4;
    static final int TOOTH_COUNT = 8;
    
    static final int IDX_TOP = 0;
    static final int IDX_RIGHT = 2;
    static final int IDX_LEFT = 6;
    
    static ArrayList<Integer>[] magnets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int commandCount = Integer.parseInt(br.readLine());
            
            magnets = new ArrayList[MAGNET_COUNT];
            for (int i = 0; i < MAGNET_COUNT; i++) {
                magnets[i] = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    magnets[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            for (int k = 0; k < commandCount; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int targetMagnet = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());

                processCommand(targetMagnet, direction);
            }

            int totalScore = calculateScore();
            sb.append("#").append(t).append(" ").append(totalScore).append("\n");
        }
        
        System.out.println(sb);
    }

    /**
     * 하나의 회전 명령을 처리하는 메서드
     * 1. 각 자석의 회전 방향을 결정 (rotatePlan 배열)
     * 2. 결정된 방향대로 실제 회전 수행 (Collections.rotate)
     */
    private static void processCommand(int targetIdx, int dir) {
        int[] rotatePlan = new int[MAGNET_COUNT]; // 각 자석의 회전 방향 저장 (0: 정지)
        rotatePlan[targetIdx] = dir;

        // 1. 타겟 기준 왼쪽 자석들 전파 확인
        for (int i = targetIdx; i > 0; i--) {
            // 왼쪽 자석(i-1)의 3시방향(2) vs 현재 자석(i)의 9시방향(6) 비교
            int leftMagnetRightTooth = magnets[i - 1].get(IDX_RIGHT);
            int currentMagnetLeftTooth = magnets[i].get(IDX_LEFT);

            if (leftMagnetRightTooth != currentMagnetLeftTooth) {
                // 극이 다르면 반대 방향으로 회전
                rotatePlan[i - 1] = rotatePlan[i] * -1;
            } else {
                // 극이 같으면 회전하지 않고 전파 중단
                break;
            }
        }

        // 2. 타겟 기준 오른쪽 자석들 전파 확인
        for (int i = targetIdx; i < MAGNET_COUNT - 1; i++) {
            // 현재 자석(i)의 3시방향(2) vs 오른쪽 자석(i+1)의 9시방향(6) 비교
            int currentMagnetRightTooth = magnets[i].get(IDX_RIGHT);
            int rightMagnetLeftTooth = magnets[i + 1].get(IDX_LEFT);

            if (currentMagnetRightTooth != rightMagnetLeftTooth) {
                // 극이 다르면 반대 방향으로 회전
                rotatePlan[i + 1] = rotatePlan[i] * -1;
            } else {
                // 극이 같으면 회전하지 않고 전파 중단
                break;
            }
        }

        // 3. 실제 회전 적용
        for (int i = 0; i < MAGNET_COUNT; i++) {
            if (rotatePlan[i] != 0) {
                // Collections.rotate: 양수면 오른쪽(시계), 음수면 왼쪽(반시계)으로 shift
                Collections.rotate(magnets[i], rotatePlan[i]);
            }
        }
    }

    /**
     * 최종 점수를 계산하는 메서드
     * 1번 자석: 1점, 2번 자석: 2점, 3번 자석: 4점, 4번 자석: 8점
     * (각 자석의 12시 방향(0번 인덱스)이 N극(0)이면 0점, S극(1)이면 점수 획득)
     */
    private static int calculateScore() {
        int sum = 0;
        for (int i = 0; i < MAGNET_COUNT; i++) {
            if (magnets[i].get(IDX_TOP) == 1) { // S극일 경우 점수 추가
                sum += (1 << i); // 2^i 점 (1, 2, 4, 8)
            }
        }
        return sum;
    }
}