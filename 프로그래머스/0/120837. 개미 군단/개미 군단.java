class Solution {
    public int solution(int hp) {
        int generals = hp / 5; // 장군개미 수
        hp %= 5; // 나머지 체력
        
        int soldiers = hp / 3; // 병정개미 수
        hp %= 3; // 나머지 체력
        
        return generals + soldiers + hp; // 장군개미 수 + 병정개미 수 + 일개미 수 반환
    }
}