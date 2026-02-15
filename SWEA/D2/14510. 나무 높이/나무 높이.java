import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 수 입력 처리 (비어있는 라인 처리 포함)
        String line = br.readLine();
        while(line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;
        
        int T = Integer.parseInt(line.trim());

        for(int tc=1; tc<=T; tc++) {
            // N 입력
            line = br.readLine();
            while(line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;
            
            int N = Integer.parseInt(line.trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int maxH = 0;
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, arr[i]);
            }

            // 1. 모든 나무를 maxH로 만드는 비용
            int ans1 = getMinDays(N, arr, maxH);
            
            // 2. 모든 나무를 maxH + 1로 만드는 비용
            int ans2 = getMinDays(N, arr, maxH + 1);

            // 둘 중 더 작은 값이 정답
            sb.append("#").append(tc).append(" ").append(Math.min(ans1, ans2)).append("\n");
        }
        System.out.print(sb);
    }

    // 목표 높이(targetH)를 맞추기 위한 최소 날짜 계산 함수
    public static int getMinDays(int N, int[] arr, int targetH) {
        int oddNeeded = 0; // 홀수 날(1점) 필수 횟수
        int evenNeeded = 0; // 짝수 날(2점) 가용 횟수

        for (int h : arr) {
            int diff = targetH - h;
            // 차이가 홀수라면 1점짜리(홀수 날) 물주기가 반드시 한 번 포함되어야 함
            if (diff % 2 != 0) {
                oddNeeded++;
                diff -= 1;
            }
            // 남은 차이는 짝수이므로 2로 나누어 짝수 날 횟수에 더함
            evenNeeded += diff / 2;
        }

        // 초기 계산된 날짜
        int minDays = calculateScore(oddNeeded, evenNeeded);

        // 균형 맞추기:
        // 2점짜리(even)가 너무 많으면, 2점 하나를 1점 두 개(odd + 2)로 쪼개는 것이 유리할 수 있음.
        // 예: 2일(2점) 하루 쉬는 것보다, 1일(1점)과 3일(1점)에 주는 것이 나을 수 있음.
        while (evenNeeded > oddNeeded) {
            evenNeeded--;
            oddNeeded += 2;
            minDays = Math.min(minDays, calculateScore(oddNeeded, evenNeeded));
        }

        return minDays;
    }

    // 홀수/짝수 필요 개수에 따른 실제 날짜 계산
    public static int calculateScore(int odd, int even) {
        if (odd > even) {
            // 홀수 날이 더 많이 필요한 경우 -> 마지막은 홀수 날에 끝남
            // 예: 1, 2, 1, 2, 1 ...
            return odd * 2 - 1;
        } else {
            // 짝수 날이 더 많거나 같은 경우 -> 마지막은 짝수 날에 끝남
            // 예: 1, 2, 1, 2 ...
            return even * 2;
        }
    }
}