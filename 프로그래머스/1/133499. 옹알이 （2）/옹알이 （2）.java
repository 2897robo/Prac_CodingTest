class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            String prev = "";
            boolean isValid = true;

            for (String w : words) {
                if (b.contains(w + w)) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) continue;

            for (String w : words) {
                b = b.replace(w, " ");
            }

            b = b.replace(" ", "");

            if (b.length() == 0) answer++;
        }

        return answer;
    }
}