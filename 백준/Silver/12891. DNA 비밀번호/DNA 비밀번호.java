import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static int P;
    static int[] CheckArr = new int[4];
    static int[] myArr = new int[4];
    static int checkCount = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        char[] DnaArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            CheckArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<P; i++) {
            if(DnaArr[i] == 'A') myArr[0]++;
            if(DnaArr[i] == 'C') myArr[1]++;
            if(DnaArr[i] == 'G') myArr[2]++;
            if(DnaArr[i] == 'T') myArr[3]++;
        }

        if(checkCounting()) {
            answer++;
        }

        int i = -1;
        for(int j=P; j<S; j++) {
            i = j-P;

            if(DnaArr[i] == 'A') myArr[0]--;
            if(DnaArr[i] == 'C') myArr[1]--;
            if(DnaArr[i] == 'G') myArr[2]--;
            if(DnaArr[i] == 'T') myArr[3]--;

            if(DnaArr[j] == 'A') myArr[0]++;
            if(DnaArr[j] == 'C') myArr[1]++;
            if(DnaArr[j] == 'G') myArr[2]++;
            if(DnaArr[j] == 'T') myArr[3]++;

            if(checkCounting()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkCounting() {
        for(int i=0; i<4; i++) {
            if(myArr[i] < CheckArr[i]) {
                return false;
            }
        }
        return true;
    }
}