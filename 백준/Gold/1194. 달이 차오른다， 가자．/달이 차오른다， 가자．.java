import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    // 상, 하, 좌, 우 이동을 위한 델타 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // BFS를 위한 Node 클래스
    static class Node {
        int r, c, dist, keys;

        public Node(int r, int c, int dist, int keys) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.keys = keys;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        // visited[행][열][열쇠상태(0~63)]
        visited = new boolean[N][M][64];

        Node startNode = null;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    startNode = new Node(i, j, 0, 0); // 시작점 저장
                    map[i][j] = '.'; // 시작점도 평지처럼 이동 가능하게 변경
                }
            }
        }

        System.out.println(bfs(startNode));
    }

    static int bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c][0] = true; // 초기 상태 방문 처리

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // 출구 도착 시 이동 횟수 반환
            if (map[curr.r][curr.c] == '1') {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                // 1. 맵 범위 체크
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                
                // 2. 벽 체크
                if (map[nr][nc] == '#') continue;

                char nextVal = map[nr][nc];
                int nextKeys = curr.keys;

                // 3. 열쇠('a'~'f')를 만난 경우 -> 비트마스킹으로 열쇠 추가
                if (nextVal >= 'a' && nextVal <= 'f') {
                    nextKeys = curr.keys | (1 << (nextVal - 'a'));
                }
                
                // 4. 문('A'~'F')을 만난 경우 -> 해당 열쇠가 있는지 확인
                if (nextVal >= 'A' && nextVal <= 'F') {
                    // 해당 비트가 0이면 열쇠가 없다는 뜻 -> 이동 불가
                    if ((curr.keys & (1 << (nextVal - 'A'))) == 0) {
                        continue;
                    }
                }

                // 5. 방문 체크 및 큐 삽입
                // 해당 위치에 '이 열쇠 조합'을 가지고 온 적이 없어야 함
                if (!visited[nr][nc][nextKeys]) {
                    visited[nr][nc][nextKeys] = true;
                    queue.offer(new Node(nr, nc, curr.dist + 1, nextKeys));
                }
            }
        }

        return -1; // 탈출 불가능
    }
}