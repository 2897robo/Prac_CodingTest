import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 받기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 문장의 개수를 입력 받음
        int N = Integer.parseInt(br.readLine());

        // N개의 줄을 처리
        for (int i = 0; i < N; i++) {
            // 문장을 입력 받음
            String sentence = br.readLine();

            // 모음을 저장할 StringBuilder
            StringBuilder vowels = new StringBuilder();

            // 문장의 각 문자에 대해 처리
            for (int j = 0; j < sentence.length(); j++) {
                char ch = sentence.charAt(j);
                // 문자가 모음인지 확인
                if (isVowel(ch)) {
                    vowels.append(ch);
                }
            }

            // 모음이 없으면 ???을 출력, 있으면 모음만 출력
            if (vowels.length() == 0) {
                System.out.println("???");
            } else {
                System.out.println(vowels.toString());
            }
        }
    }

    // 모음 여부를 확인하는 함수
    private static boolean isVowel(char ch) {
        // 대소문자를 구분하지 않기 위해 소문자로 변환하여 확인
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
