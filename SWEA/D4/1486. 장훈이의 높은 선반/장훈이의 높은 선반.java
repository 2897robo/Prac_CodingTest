// SWEA - 1486 장훈이의 높은 선반

import java.io.*;
import java.util.*;

public class Solution {
    static int N, B; // N: 점원 수, B: 선반 높이
    static int[] heights; // 점원들의 키 배열
    static int minDiff; // B이상인 탑 중에서 B와의 최소 차이 (정답)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // 초기화: 최소 차이는 최댓값으로 설정
            minDiff = Integer.MAX_VALUE;

            // 부분집합 탐색 시작 (0번 점원부터, 현재 높이 합 0)
            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(minDiff).append("\n");
        }
        System.out.println(sb);
    }

    // cnt: 현재 고려하는 점원의 인덱스
    // sum: 현재까지 쌓은 탑의 높이
    static void dfs(int cnt, int sum) {
        // [가지치기 & 정답 갱신]
        // 현재 합이 B 이상이 되면 조건을 만족함
        if (sum >= B) {
            // 차이가 더 작은 값으로 갱신
            minDiff = Math.min(minDiff, sum - B);
            // 이미 B를 넘었으므로, 여기서 더 더해봤자 차이만 커짐 -> 그만 탐색 (Pruning)
            return;
        }

        // [기저 조건] 모든 점원을 다 고려했으면 종료
        if (cnt == N) {
            return;
        }

        // [유도 파트]
        // 1. 현재 점원을 탑에 포함시키는 경우
        dfs(cnt + 1, sum + heights[cnt]);

        // 2. 현재 점원을 탑에 포함시키지 않는 경우
        dfs(cnt + 1, sum);
    }
}