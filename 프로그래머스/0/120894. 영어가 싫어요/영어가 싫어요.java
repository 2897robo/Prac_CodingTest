class Solution {
    public long solution(String numbers) {
        // 영어 단어를 숫자로 매핑
        numbers = numbers.replace("zero", "0")
                         .replace("one", "1")
                         .replace("two", "2")
                         .replace("three", "3")
                         .replace("four", "4")
                         .replace("five", "5")
                         .replace("six", "6")
                         .replace("seven", "7")
                         .replace("eight", "8")
                         .replace("nine", "9");
        
        // 변환된 문자열을 정수로 변환
        long answer = Long.parseLong(numbers);
        
        return answer;
    }
}
