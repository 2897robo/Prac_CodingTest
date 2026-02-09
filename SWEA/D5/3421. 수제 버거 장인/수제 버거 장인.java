import java.io.*;
import java.util.*;

public class Solution {
    
    static int N, M;
    static boolean[][] isBad; // 궁합이 안 맞는 재료 관계 (인접 행렬)
    static boolean[] isSelected; // 현재 버거에 들어간 재료 체크
    static int answer; // 가능한 버거의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 개수 (1~N)
            M = Integer.parseInt(st.nextToken()); // 안 맞는 쌍의 개수
            
            // 초기화
            isBad = new boolean[N + 1][N + 1];
            isSelected = new boolean[N + 1];
            answer = 0;

            // 궁합 정보 입력 (M개)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                // 양방향으로 체크 (a와 b는 같이 못 씀)
                isBad[a][b] = true;
                isBad[b][a] = true;
            }

            // DFS 탐색 시작 (1번 재료부터 고려)
            dfs(1);
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        
        System.out.println(sb);
    }

    // index: 현재 고려하고 있는 재료 번호
    public static void dfs(int index) {
        // [기저 조건] N번 재료까지 모든 선택을 마쳤을 때
        if (index == N + 1) {
            answer++; // 여기까지 무사히 도달했다면 유효한 버거 1개 완성
            return;
        }

        // [유도 파트 1] 현재 재료(index)를 "안 넣는" 경우
        // 안 넣는 건 제약 조건이 없으므로 바로 다음으로 넘어감
        isSelected[index] = false; 
        dfs(index + 1);

        // [유도 파트 2] 현재 재료(index)를 "넣는" 경우
        // 넣기 전에, 이미 선택된 재료들과 싸우지 않는지 확인해야 함
        if (isPossible(index)) {
            isSelected[index] = true;  // 넣음 표시
            dfs(index + 1);            // 다음 재료로
            isSelected[index] = false; // (백트래킹) 돌아오면 원상복구
        }
    }

    // 현재 재료(current)를 넣어도 되는지 검사하는 함수
    public static boolean isPossible(int current) {
        // 1번부터 현재 재료 직전까지 스캔
        for (int i = 1; i < current; i++) {
            // 만약 i번 재료가 이미 햄버거에 들어있고(isSelected[i]),
            // 현재 재료와 궁합이 안 맞다면(isBad[current][i]) -> 불가능
            if (isSelected[i] && isBad[current][i]) {
                return false;
            }
        }
        return true;
    }
}