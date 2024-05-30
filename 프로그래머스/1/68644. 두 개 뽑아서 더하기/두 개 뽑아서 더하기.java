import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> resultSet = new TreeSet<>(); // 중복을 허용하지 않고 정렬된 순서로 값을 저장하기 위해 Set 및 TreeSet을 사용합니다.
        
        for (int i = 0; i < numbers.length - 1; i++) { // 배열의 마지막 요소 다음에 오는 요소를 더하는 것을 방지하기 위해 length - 1까지만 순회합니다.
            for (int j = i + 1; j < numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]); // 각 요소와 그 다음 요소를 더한 값을 Set에 추가합니다.
            }
        }
        
        // Set을 배열로 변환합니다.
        int[] answer = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            answer[index++] = num;
        }
        
        return answer;
    }
}
