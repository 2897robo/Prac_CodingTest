import java.util.*;

class Solution {
    public String solution(String s) {
        // 1. 각 문자의 빈도 수를 저장할 HashMap 생성
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        // 2. 문자열 s를 순회하며 빈도 수 계산
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // 3. 한 번만 등장하는 문자를 저장할 리스트 생성
        List<Character> uniqueChars = new ArrayList<>();
        
        // 4. 빈도 수가 1인 문자들을 리스트에 추가
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.add(entry.getKey());
            }
        }
        
        // 5. 리스트를 사전 순으로 정렬
        Collections.sort(uniqueChars);
        
        // 6. 리스트의 문자를 문자열로 변환
        StringBuilder answer = new StringBuilder();
        for (char c : uniqueChars) {
            answer.append(c);
        }
        
        // 7. 결과 문자열 반환
        return answer.toString();
    }
}
