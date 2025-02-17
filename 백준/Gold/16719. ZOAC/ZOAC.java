import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문 체크 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        visited = new boolean[c.length];

        solve(c, 0, c.length - 1);
        br.close();
    }

    static void solve(char[] c, int start, int end) {
        if (start > end) return;

        // 현재 범위에서 사전 순으로 가장 앞선 문자 찾기
        int minIdx = -1;
        char minChar = 'Z' + 1; // 가장 큰 문자보다 큰 값으로 초기화

        for (int i = start; i <= end; i++) {
            if (!visited[i] && c[i] < minChar) { // 방문하지 않은 문자 중 가장 작은 문자 찾기
                minIdx = i;
                minChar = c[i];
            }
        }

        if (minIdx == -1) return; // 종료 조건

        // 선택한 문자 방문 처리
        visited[minIdx] = true;

        // 현재까지 방문된 문자 출력
        printCurrentState(c);

        // 오른쪽 부분 탐색
        solve(c, minIdx + 1, end);
        // 왼쪽 부분 탐색 (이전에는 왼쪽 탐색이 없었음)
        solve(c, start, minIdx - 1);
    }

    static void printCurrentState(char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (visited[i]) System.out.print(c[i]);
        }
        System.out.println();
    }
}
