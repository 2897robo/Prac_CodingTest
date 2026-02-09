import java.io.*;
import java.util.*;

public class Solution {
    
    // 상(0), 하(1), 좌(2), 우(3) - 델타 배열
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    // 전차의 모양과 명령어를 인덱스로 매핑하기 위한 배열들
    static char[] tankShapes = {'^', 'v', '<', '>'};
    static char[] moveCmds = {'U', 'D', 'L', 'R'};
    
    static int H, W;
    static char[][] map;
    static int ty, tx, tDir; // 전차 위치(y, x) 및 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 높이
            W = Integer.parseInt(st.nextToken()); // 너비

            map = new char[H][W];
            
            // 1. 맵 입력 받으면서 전차 위치 찾기
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    
                    // 전차인지 확인
                    if (isTank(map[i][j])) {
                        ty = i;
                        tx = j;
                        tDir = getDirection(map[i][j]); // 전차의 초기 방향 설정
                    }
                }
            }

            // 2. 명령어 처리
            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (int k = 0; k < N; k++) {
                char cmd = commands.charAt(k);
                
                if (cmd == 'S') {
                    shoot();
                } else {
                    move(cmd);
                }
            }

            // 3. 결과 출력
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    // 전차 이동 로직
    static void move(char cmd) {
        // 1. 명령어에 따라 방향 전환
        int nextDir = -1;
        for(int i=0; i<4; i++) {
            if(moveCmds[i] == cmd) {
                nextDir = i;
                break;
            }
        }
        
        tDir = nextDir; // 방향 갱신
        map[ty][tx] = tankShapes[tDir]; // 맵상의 전차 모양 변경 (이동 못해도 방향은 바뀜)

        // 2. 이동할 위치 계산
        int ny = ty + dy[tDir];
        int nx = tx + dx[tDir];

        // 3. 맵 범위 안이고, 평지(.)라면 이동
        if (ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
            map[ty][tx] = '.'; // 원래 있던 자리는 평지로
            ty = ny;
            tx = nx;
            map[ty][tx] = tankShapes[tDir]; // 새 자리에 전차 배치
        }
    }

    // 포탄 발사 로직
    static void shoot() {
        int by = ty;
        int bx = tx;

        // 벽에 부딪히거나 맵 밖으로 나갈 때까지 직진
        while (true) {
            by += dy[tDir];
            bx += dx[tDir];

            // 맵 밖으로 나가면 소멸
            if (by < 0 || by >= H || bx < 0 || bx >= W) break;

            // 강철벽(#) -> 아무 일 없음, 포탄 소멸
            if (map[by][bx] == '#') break;

            // 벽돌벽(*) -> 벽 파괴(평지로 변환), 포탄 소멸
            if (map[by][bx] == '*') {
                map[by][bx] = '.';
                break;
            }
            
            // 물(-)이나 평지(.)는 통과하므로 loop 계속 진행
        }
    }

    // 해당 문자가 전차인지 확인하는 헬퍼 함수
    static boolean isTank(char c) {
        return c == '^' || c == 'v' || c == '<' || c == '>';
    }

    // 전차 문자를 방향 인덱스로 변환하는 헬퍼 함수
    static int getDirection(char c) {
        if (c == '^') return 0;
        if (c == 'v') return 1;
        if (c == '<') return 2;
        if (c == '>') return 3;
        return -1;
    }
}