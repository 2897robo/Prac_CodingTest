class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for(String i : order) {
            if(i.contains("no")) {
                answer += 4500;
            }
            else if(i.contains("latte")) {
                answer += 5000;
            }
            else if(i.contains("any")) {
                answer += 4500;
            }
        }
        return answer;
    }
}