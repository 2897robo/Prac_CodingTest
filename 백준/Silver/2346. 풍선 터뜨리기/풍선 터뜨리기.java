import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Balloon {
        int index;
        int value;

        Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Balloon> list = new LinkedList<>();

        // 풍선 초기화
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.add(new Balloon(i + 1, value));
        }

        StringBuilder result = new StringBuilder();
        int currentIndex = 0;

        while (!list.isEmpty()) {
            Balloon current = list.remove(currentIndex);
            result.append(current.index).append(" ");

            if (list.isEmpty()) {
                break;
            }

            int move = current.value;
            int size = list.size();

            if (move > 0) {
                currentIndex = (currentIndex + (move - 1)) % size;
            } else {
                currentIndex = (currentIndex + move % size + size) % size;
            }
        }

        // 결과 출력
        System.out.println(result.toString().trim());
    }
}
