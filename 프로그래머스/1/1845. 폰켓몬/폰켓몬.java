import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 중복 제거용 Set (서로 다른 포켓몬 종류 수 체크용)
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        // 최대 고를 수 있는 개수 = 전체 개수의 절반
        int maxSelectable = nums.length / 2;

        // 서로 다른 종류 수 vs 선택 가능한 수 중 더 작은 값이 정답
        return Math.min(set.size(), maxSelectable);
    }
}