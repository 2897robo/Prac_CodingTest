import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String myStr) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 문자열을 순회하면서 "a", "b", "c"를 구분자로 사용해 문자열을 나눕니다.
        for (char c : myStr.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                if (sb.length() > 0) {
                    result.add(sb.toString());
                    sb.setLength(0); // StringBuilder를 비웁니다.
                }
            } else {
                sb.append(c);
            }
        }

        // 남아 있는 문자열이 있다면 결과 리스트에 추가합니다.
        if (sb.length() > 0) {
            result.add(sb.toString());
        }

        // 결과 리스트를 배열로 변환하여 반환합니다.
        if (result.isEmpty()) {
            return new String[]{"EMPTY"};
        } else {
            return result.toArray(new String[0]);
        }
    }
}
