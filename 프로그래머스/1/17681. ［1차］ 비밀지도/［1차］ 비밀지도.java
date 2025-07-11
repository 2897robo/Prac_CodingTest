class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            int comb = arr1[i] | arr2[i];
            String binary = String.format("%" + n + "s", Integer.toBinaryString(comb));
            binary = binary.replace('1', '#').replace('0', ' ');
            answer[i] = binary;
        }
        return answer;
    }
}