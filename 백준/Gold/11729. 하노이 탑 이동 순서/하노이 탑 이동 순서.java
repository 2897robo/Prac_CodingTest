import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0; // 이동 횟수 저장

    public static void hanoi(int n, int from, int to, int aux) throws IOException {
        if (n == 1) {
            count++;
            bw.write(from + " " + to + "\n");
            return;
        }

        // 1. N-1개의 원판을 보조 기둥(aux)으로 이동
        hanoi(n - 1, from, aux, to);
        count++;
        
        // 2. 가장 큰 원판을 목적지(to)로 이동
        bw.write(from + " " + to + "\n");

        // 3. N-1개의 원판을 목적지(to)로 이동
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 최소 이동 횟수: 2^N - 1
        bw.write((1 << n) - 1 + "\n");

        // N이 20 이하일 때만 이동 과정 출력
        if (n <= 20) {
            hanoi(n, 1, 3, 2);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}