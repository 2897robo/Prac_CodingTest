import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int hour = sc.nextInt(); // 현재 시
        int minute = sc.nextInt(); // 현재 분
        int cookTime = sc.nextInt(); // 요리 시간
        
        int totalMinutes = hour * 60 + minute + cookTime; // 총 분으로 환산
        int endHour = (totalMinutes / 60) % 24; // 최종 시
        int endMinute = totalMinutes % 60; // 최종 분
        
        System.out.println(endHour + " " + endMinute);
    }
}
