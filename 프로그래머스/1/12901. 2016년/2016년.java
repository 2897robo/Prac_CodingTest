class Solution {
    public String solution(int a, int b) {
        String[] weekdays = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] daysOfMonth = {31, 29, 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        for(int i = 0; i < a - 1; i++) {
            totalDays += daysOfMonth[i];
        }
        totalDays += b;

        return weekdays[(totalDays + 4) % 7];
    }
}