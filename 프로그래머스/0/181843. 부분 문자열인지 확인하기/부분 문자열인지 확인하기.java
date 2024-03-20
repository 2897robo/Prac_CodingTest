class Solution {
    public int solution(String my_string, String target) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(my_string);
        return tmp.toString().contains(target) ? 1 : 0;
    }
}
