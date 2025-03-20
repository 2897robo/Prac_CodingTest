import java.io.*;
import java.util.*;

public class Main {
    static int N, K, maxReadable = 0;
    static int[] wordsMask;
    static final int REQUIRED_MASK = (1 << ('a' - 'a')) | (1 << ('n' - 'a')) |
                                     (1 << ('t' - 'a')) | (1 << ('i' - 'a')) |
                                     (1 << ('c' - 'a'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // K가 5보다 작으면 필수 글자(a, n, t, i, c)도 못 배우므로 바로 0 출력
        if (K < 5) {
            System.out.println(0);
            return;
        }

        wordsMask = new int[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            wordsMask[i] = mask;
        }

        // 백트래킹을 이용한 문자 조합 탐색
        selectAlphabets(0, 0, REQUIRED_MASK);
        System.out.println(maxReadable);
    }

    // 백트래킹: 글자를 K-5개 선택 (이미 5개는 고정됨)
    static void selectAlphabets(int idx, int count, int mask) {
        if (count == K - 5) { // K-5개의 글자를 선택한 경우
            maxReadable = Math.max(maxReadable, countReadableWords(mask));
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((REQUIRED_MASK & (1 << i)) == 0) { // 이미 배운 5개(a, n, t, i, c)는 제외
                selectAlphabets(i + 1, count + 1, mask | (1 << i));
            }
        }
    }

    // 현재 배운 글자로 읽을 수 있는 단어 개수 계산
    static int countReadableWords(int mask) {
        int count = 0;
        for (int wordMask : wordsMask) {
            if ((wordMask & mask) == wordMask) { // 배운 글자로 완전히 포함될 경우 읽을 수 있음
                count++;
            }
        }
        return count;
    }
}