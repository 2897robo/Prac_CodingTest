class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        int idx2 = 1;
        
        if(direction.equals("right")) {
            answer[0] = numbers[numbers.length-1];
            for(int i=1; i<=numbers.length-1; i++) {
                answer[i] = numbers[idx++];        
            }
        } else if(direction.equals("left")) {
            answer[answer.length-1] = numbers[0];
            for(int i=0; i<numbers.length-1; i++) {
                answer[i] = numbers[idx2++];
            }
        }
        return answer;
    }
}