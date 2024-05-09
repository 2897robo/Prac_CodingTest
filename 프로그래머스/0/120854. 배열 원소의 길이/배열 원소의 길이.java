class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length]; // 결과를 저장할 배열 생성
        for (int i = 0; i < strlist.length; i++) {
            answer[i] = strlist[i].length(); // 각 원소의 길이를 계산하여 결과 배열에 저장
        }
        return answer; // 결과 배열 반환
    }
}
