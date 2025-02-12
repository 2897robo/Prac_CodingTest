import java.io.*;
import java.util.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int nowHour = Integer.parseInt(st.nextToken());
        int nowMin = Integer.parseInt(st.nextToken());
        int nowSec = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ":");
        int throwHour = Integer.parseInt(st.nextToken());
        int throwMin = Integer.parseInt(st.nextToken());
        int throwSec = Integer.parseInt(st.nextToken());

        int nowTime = nowHour * 3600 + nowMin * 60 + nowSec;
        int throwTime = throwHour * 3600 + throwMin * 60 + throwSec;

        int answerTime = (throwTime - nowTime + 86400) % 86400;
        if(answerTime == 0) answerTime = 86400;

        int answerHour = answerTime / 3600;
        int answerMin = answerTime % 3600 / 60;
        int answerSec = answerTime % 3600 % 60;

        bw.write(String.format("%02d:%02d:%02d\n", answerHour, answerMin, answerSec));
        bw.flush();
        br.close();
        bw.close();
    }
}