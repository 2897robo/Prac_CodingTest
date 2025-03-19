import java.io.*;
import java.util.*;

public class Main {
    static int N, K, maxWords = 0;
    static List<Integer> wordMasks = new ArrayList<>();
    static boolean[] learned = new boolean[26]; // 알파벳 학습 여부 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 단어 개수
        K = Integer.parseInt(st.nextToken()); // 배울 글자 수

        // K가 5보다 작으면 필수 글자(a, n, t, i, c)도 못 배우므로 바로 0 출력
        if (K < 5) {
            System.out.println(0);
            return;
        }

        // 필수 글자 학습 설정
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        // 단어 입력받고 비트마스크 변환하여 저장
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int mask = 0;

            // "anta"와 "tica" 제거 후 비트마스크 변환
            for (char ch : word.substring(4, word.length() - 4).toCharArray()) {
                mask |= (1 << (ch - 'a')); // 해당 문자 비트 설정
            }

            wordMasks.add(mask); // 비트마스크 형태로 저장
        }

        // 백트래킹을 이용한 문자 조합 탐색
        dfs(0, 0);

        // 결과 출력
        System.out.println(maxWords);
    }

    // 백트래킹: 글자를 K-5개 선택 (이미 5개는 고정됨)
    public static void dfs(int index, int count) {
        if (count == K - 5) { // K-5개의 글자를 선택한 경우
            maxWords = Math.max(maxWords, countReadableWords());
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                dfs(i + 1, count + 1);
                learned[i] = false; // 백트래킹
            }
        }
    }

    // 현재 배운 글자로 읽을 수 있는 단어 개수 계산 (비트마스크 활용)
    public static int countReadableWords() {
        int count = 0;

        for (int mask : wordMasks) {
            if ((mask & getLearnedMask()) == mask) { // 배운 글자로만 이루어졌다면
                count++;
            }
        }

        return count;
    }

    // 현재 배운 글자를 비트마스크로 변환하여 반환
    public static int getLearnedMask() {
        int mask = 0;
        for (int i = 0; i < 26; i++) {
            if (learned[i]) mask |= (1 << i);
        }
        return mask;
    }
}