import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> tmp = new ArrayList<Integer>();
        
        tmp.add(n); // 초기 값인 n을 리스트에 추가
        
        while(n != 1) {
            if(n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            tmp.add(n); // 각 단계의 값을 리스트에 추가
        }
        
        int[] answer = new int[tmp.size()];
        
        for(int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i); // 리스트의 값을 배열로 복사
        }
        
        return answer;
    }
}
