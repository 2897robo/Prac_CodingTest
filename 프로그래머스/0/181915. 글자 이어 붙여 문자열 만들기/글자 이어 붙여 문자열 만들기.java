class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] tmp = my_string.toCharArray();
        char[] re = new char[index_list.length];
        
        for(int i=0; i<index_list.length; i++) {
            re[i] = tmp[index_list[i]];
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<re.length; i++) {
            result.append(re[i]);
        }
        
        return result.toString();
    }
}