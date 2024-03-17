import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        int pow = 0;
        int size = list.size();
        for(int i = 0; i < 11; i++) {
            if(size <= Math.pow(2, i)) {
                pow = i;
                break;
            }
        }

        int a = (int) Math.pow(2, pow);
        if(size == a) {
            return arr;
        } else {
            for(int i = 0; i < a - size; i++) {
                list.add(0);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}