import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] map;
    static ArrayList<Core> coreList;
    static int maxCores; // 최대 연결 코어 수
    static int minWireLength; // 최소 전선 길이
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Core {
        int x, y;
        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 가장자리가 아닌 코어만 리스트에 추가
                    if (map[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            continue; 
                        }
                        coreList.add(new Core(i, j));
                    }
                }
            }

            maxCores = Integer.MIN_VALUE;
            minWireLength = Integer.MAX_VALUE;

            // DFS 탐색 시작 (인덱스, 연결된 코어 수, 전선 길이 합)
            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(minWireLength).append("\n");
        }
        System.out.println(sb);
    }

    // idx: 현재 고려 중인 코어의 인덱스
    // cnt: 현재까지 연결된 코어 수
    // len: 현재까지 사용한 전선 길이
    static void dfs(int idx, int cnt, int len) {
        // [기저 조건] 모든 코어를 다 확인했을 때
        if (idx == coreList.size()) {
            if (cnt > maxCores) {
                maxCores = cnt;
                minWireLength = len;
            } else if (cnt == maxCores) {
                minWireLength = Math.min(minWireLength, len);
            }
            return;
        }
        
        // [가지치기] 남은 코어를 다 연결해도 현재 최대 코어 수보다 적으면 더 볼 필요 없음
        // (현재 연결된 수 + 남은 코어 수 < 최대 연결 수)
        if (cnt + (coreList.size() - idx) < maxCores) {
            return;
        }

        Core current = coreList.get(idx);

        // 4방향 탐색
        for (int d = 0; d < 4; d++) {
            // 해당 방향으로 전선 설치가 가능한지 확인 (길이 반환, 불가능하면 0)
            int wireLen = checkStatus(current.x, current.y, d);
            
            if (wireLen > 0) {
                // 전선 설치 (지도에 2로 표시)
                setStatus(current.x, current.y, d, 2);
                
                // 다음 코어로 이동
                dfs(idx + 1, cnt + 1, len + wireLen);
                
                // [백트래킹] 전선 해제 (지도에 0으로 복구)
                setStatus(current.x, current.y, d, 0);
            }
        }

        // 해당 코어를 연결하지 않고 다음으로 넘어가는 경우
        dfs(idx + 1, cnt, len);
    }

    // 해당 방향으로 전선을 설치할 수 있는지 체크하고 길이를 반환
    static int checkStatus(int r, int c, int dir) {
        int count = 0;
        int nx = r + dx[dir];
        int ny = c + dy[dir];

        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            if (map[nx][ny] != 0) { // 코어(1)나 전선(2)을 만나면 불가능
                return 0;
            }
            nx += dx[dir];
            ny += dy[dir];
            count++;
        }
        return count;
    }

    // 전선을 실제로 설치하거나 제거하는 함수
    // type: 2(설치), 0(제거)
    static void setStatus(int r, int c, int dir, int type) {
        int nx = r + dx[dir];
        int ny = c + dy[dir];

        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            map[nx][ny] = type;
            nx += dx[dir];
            ny += dy[dir];
        }
    }
}