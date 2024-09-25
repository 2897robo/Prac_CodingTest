import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        // 현재 위치를 (0,0)으로 설정
        int x = 0;
        int y = 0;
        
        // 지나간 길을 저장하기 위한 Set
        Set<String> visited = new HashSet<>();
        
        // 이동 명령어에 따른 방향 변화 (상, 하, 좌, 우)
        int[] dx = {0, 0, -1, 1};  // 좌우
        int[] dy = {1, -1, 0, 0};  // 상하
        String direction = "UDLR"; // 명령어의 순서와 매칭
        
        for (char dir : dirs.toCharArray()) {
            // 현재 명령어의 방향 인덱스를 얻음
            int idx = direction.indexOf(dir);
            
            // 새로운 좌표 계산
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            // 좌표가 경계를 넘어서면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            // 지나간 경로 저장 (현재 좌표 -> 다음 좌표, 양방향 저장)
            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;
            
            // 처음 지나간 길이면 Set에 추가하고, 길이를 증가시킴
            if (!visited.contains(path1)) {
                visited.add(path1);
                visited.add(path2); // 양방향 저장
            }
            
            // 현재 좌표를 업데이트
            x = nx;
            y = ny;
        }
        
        // 총 길이는 방문한 경로 수의 절반 (양방향 저장했기 때문에)
        return visited.size() / 2;
    }
}
