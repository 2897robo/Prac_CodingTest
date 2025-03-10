import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;

    public static void divideAndConquer(int n, int x, int y, int r, int c) {
        if(n==0) return;

        int size = 1 << (n-1);
        int blockSize = size * size;

        if(r < x+size && c < y+size) {
            divideAndConquer(n-1, x, y, r, c);
        } else if(r < x+size) {
            count += blockSize;
            divideAndConquer(n-1, x, y+size, r, c);
        } else if(c < y+size) {
            count += 2*blockSize;
            divideAndConquer(n-1, x+size, y, r, c);
        } else {
            count += 3*blockSize;
            divideAndConquer(n-1, x+size, y+size, r, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        divideAndConquer(n, 0, 0, r, c);

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
