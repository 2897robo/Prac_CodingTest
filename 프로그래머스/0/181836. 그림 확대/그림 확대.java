public class Solution {
    public String[] solution(String[] picture, int k) {
        int rows = picture.length;
        int cols = picture[0].length();
        String[] result = new String[rows * k];
        
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            // 각 문자를 k배 확대
            for (char c : picture[i].toCharArray()) {
                for (int j = 0; j < k; j++) {
                    sb.append(c);
                }
            }
            // 확대된 행을 k번 반복
            String expandedRow = sb.toString();
            for (int j = 0; j < k; j++) {
                result[i * k + j] = expandedRow;
            }
        }
        
        return result;
    }
}