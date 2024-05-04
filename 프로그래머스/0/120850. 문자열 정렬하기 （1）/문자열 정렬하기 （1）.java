import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // 문자열에서 숫자만 추출하여 리스트에 추가
        for(char ch : my_string.toCharArray()) {
            if(Character.isDigit(ch)) {
                numbers.add(Character.getNumericValue(ch));
            }
        }
        
        // 리스트를 오름차순으로 정렬
        Collections.sort(numbers);
        
        // 결과를 int 배열로 변환
        int[] answer = new int[numbers.size()];
        for(int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        
        return answer;
    }
}
