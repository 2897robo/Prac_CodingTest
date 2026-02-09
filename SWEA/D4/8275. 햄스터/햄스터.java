// SWEA - 8275 햄스터

import java.io.*;
import java.util.*;

public class Solution {
    static int N, X, M;
    static int[][] records; // 경근이의 기록을 저장할 배열
    static int[] currentCages; // 현재 탐색 중인 햄스터 배치
    static int[] bestCages; // 조건을 만족하는 최적의 햄스터 배치
    static int maxTotalHamsters; // 발견된 최대 햄스터 총합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 우리 개수
            X = Integer.parseInt(st.nextToken()); // 우리 당 최대 햄스터 수
            M = Integer.parseInt(st.nextToken()); // 기록 개수

            records = new int[M][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                records[i][0] = Integer.parseInt(st.nextToken()); // l
                records[i][1] = Integer.parseInt(st.nextToken()); // r
                records[i][2] = Integer.parseInt(st.nextToken()); // s
            }

            currentCages = new int[N + 1]; // 1-based indexing 사용
            bestCages = null;
            maxTotalHamsters = -1;

            // DFS 탐색 시작 (1번 우리부터, 현재 총합 0)
            dfs(1, 0);

            sb.append("#").append(t).append(" ");
            if (bestCages == null) {
                sb.append("-1");
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(bestCages[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // depth: 현재 결정할 우리 번호
    // currentSum: 현재까지 배치된 햄스터의 총합
    static void dfs(int depth, int currentSum) {
        // [기저 조건] 모든 우리의 햄스터 수를 결정했을 때
        if (depth == N + 1) {
            // 1. 기록된 M개의 조건을 모두 만족하는지 검사
            if (checkConstraints()) {
                // 2. 조건을 만족한다면, 총합이 더 클 때만 갱신
                // (탐색 순서가 0부터 X까지 진행되므로, 합이 같을 때는 먼저 발견된 것이 사전순으로 앞섬 -> 갱신 X)
                if (currentSum > maxTotalHamsters) {
                    maxTotalHamsters = currentSum;
                    bestCages = currentCages.clone(); // 배열 깊은 복사
                }
            }
            return;
        }

        // [유도 부분] 0마리부터 X마리까지 시도 (사전순 탐색을 위해 오름차순)
        for (int i = 0; i <= X; i++) {
            currentCages[depth] = i;
            dfs(depth + 1, currentSum + i);
        }
    }

    // 현재 배치가 경근이의 기록을 모두 만족하는지 확인
    static boolean checkConstraints() {
        for (int i = 0; i < M; i++) {
            int l = records[i][0];
            int r = records[i][1];
            int s = records[i][2];

            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += currentCages[j];
            }

            if (sum != s) {
                return false;
            }
        }
        return true;
    }
}