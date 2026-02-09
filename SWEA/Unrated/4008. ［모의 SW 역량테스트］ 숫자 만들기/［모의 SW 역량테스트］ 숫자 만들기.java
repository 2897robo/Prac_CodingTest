import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[] ops; // 연산자 개수 저장: 0(+), 1(-), 2(*), 3(/)
    static int[] nums; // 숫자 저장
    static long maxResult; // 최댓값 (범위 고려하여 long 사용)
    static long minResult; // 최솟값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 줄에 테스트 케이스 수 T
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 숫자의 개수

            ops = new int[4]; // +, -, *, / 순서
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                ops[i] = Integer.parseInt(st.nextToken());
            }

            nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 최댓값, 최솟값 초기화
            maxResult = Long.MIN_VALUE;
            minResult = Long.MAX_VALUE;

            // DFS 탐색 시작 (첫 번째 숫자를 가지고 시작, 인덱스는 1부터)
            dfs(1, nums[0]);
            
            // 결과 차이 구하기 (문제 요구사항은 차이)
            // 주의: 예시 출력에는 차이값(절대값 개념)이 아니라 그냥 계산된 값을 원할 수도 있으나,
            // 문제 설명의 "두 값의 차이를 출력하시오"에 따라 (최대 - 최소)를 출력합니다.
            long ans = maxResult - minResult;
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    // idx: 다음 사용할 숫자의 인덱스
    // currentVal: 현재까지 계산된 값
    public static void dfs(int idx, long currentVal) {
        // [기저 조건] 모든 숫자를 다 사용했을 때
        if (idx == N) {
            maxResult = Math.max(maxResult, currentVal);
            minResult = Math.min(minResult, currentVal);
            return;
        }

        // [유도 파트] 4가지 연산자를 하나씩 시도
        // 1. 더하기 (+)
        if (ops[0] > 0) {
            ops[0]--; // 연산자 사용
            dfs(idx + 1, currentVal + nums[idx]);
            ops[0]++; // 백트래킹 (복구)
        }

        // 2. 빼기 (-)
        if (ops[1] > 0) {
            ops[1]--;
            dfs(idx + 1, currentVal - nums[idx]);
            ops[1]++;
        }

        // 3. 곱하기 (*)
        if (ops[2] > 0) {
            ops[2]--;
            dfs(idx + 1, currentVal * nums[idx]);
            ops[2]++;
        }

        // 4. 나누기 (/)
        if (ops[3] > 0) {
            ops[3]--;
            // 문제 조건: 나눗셈은 정수 나눗셈 (소수점 버림) - Java 기본 동작과 일치
            dfs(idx + 1, currentVal / nums[idx]);
            ops[3]++;
        }
    }
}