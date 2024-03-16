import java.util.*;

class Solution {
    public String[] solution(String myString) {
        // 문자열을 "x"를 기준으로 분리하여 문자열 배열을 얻습니다.
        String[] parts = myString.split("x");
        
        // 빈 문자열을 걸러내고 사전순으로 정렬합니다.
        List<String> resultList = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) {
                resultList.add(part);
            }
        }
        Collections.sort(resultList);
        
        // 리스트를 배열로 변환하여 반환합니다.
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        
        return result;
    }
}
