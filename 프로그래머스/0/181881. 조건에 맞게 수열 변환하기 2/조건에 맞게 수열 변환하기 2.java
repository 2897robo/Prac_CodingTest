import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int count = 0; // 반복 횟수를 저장할 변수
        
        while (true) {
            int[] newArr = new int[arr.length]; // 새로운 배열을 생성
            
            // 새로운 배열을 생성
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    newArr[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    newArr[i] = arr[i] * 2 + 1;
                } else {
                    newArr[i] = arr[i];
                }
            }
            
            // 새로운 배열과 원래 배열이 같은지 확인
            if (Arrays.equals(newArr, arr)) {
                break; // 같으면 반복 종료
            }
            
            arr = newArr; // 새로운 배열로 업데이트
            count++; // 반복 횟수 증가
        }
        
        return count; // 반복 횟수 반환
    }
}
