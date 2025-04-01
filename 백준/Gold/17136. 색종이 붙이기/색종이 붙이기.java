import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[10][10];       // 10x10 종이
    static int[] paper = {0, 5, 5, 5, 5, 5};    // 각 크기별 색종이 5장씩
    static int min = Integer.MAX_VALUE;         // 최소 색종이 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0); // 탐색 시작

        // 결과 출력
        bw.write((min == Integer.MAX_VALUE ? -1 : min) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    // DFS + 백트래킹
    public static void dfs(int x, int y, int cnt) {
        if (x >= 10) {
            min = Math.min(min, cnt);
            return;
        }

        if (cnt >= min) return; // 이미 최소값보다 커지면 가지치기

        if (y >= 10) {
            dfs(x + 1, 0, cnt); // 다음 행으로 이동
            return;
        }

        if (arr[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paper[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0);
                    paper[size]--;
                    dfs(x, y + 1, cnt + 1);
                    attach(x, y, size, 1); // 복구
                    paper[size]++;
                }
            }
        } else {
            dfs(x, y + 1, cnt); // 0이면 그냥 다음 칸
        }
    }

    // 색종이 붙일 수 있는지 확인
    public static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != 1) return false;
            }
        }
        return true;
    }

    // 색종이 붙이거나 떼기
    public static void attach(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                arr[i][j] = value;
            }
        }
    }
}