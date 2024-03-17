public class Solution {
    public int[] solution(String myString) {
        String[] splittedStrings = myString.split("x", -1);
        int[] lengths = new int[splittedStrings.length];
        
        for (int i = 0; i < splittedStrings.length; i++) {
            lengths[i] = splittedStrings[i].length();
        }
        
        return lengths;
    }
}