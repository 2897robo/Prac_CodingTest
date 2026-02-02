// BOJ 12891 - DNA 비밀번호

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int requiredA = Integer.parseInt(st.nextToken());
        int requiredC = Integer.parseInt(st.nextToken());
        int requiredG = Integer.parseInt(st.nextToken());
        int requiredT = Integer.parseInt(st.nextToken());
        int countA = 0, countC = 0, countG = 0, countT = 0;

        for (int i = 0; i < p; i++) {
            switch (dna[i]) {
                case 'A':
                    countA++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'G':
                    countG++;
                    break;
                case 'T':
                    countT++;
                    break;
            }
        }

        int validPasswords = 0;
        if (countA >= requiredA && countC >= requiredC && countG >= requiredG && countT >= requiredT) {
            validPasswords++;
        }

        for (int i = p; i < s; i++) {
            switch (dna[i - p]) {
                case 'A':
                    countA--;
                    break;
                case 'C':
                    countC--;
                    break;
                case 'G':
                    countG--;
                    break;
                case 'T':
                    countT--;
                    break;
            }

            switch (dna[i]) {
                case 'A':
                    countA++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'G':
                    countG++;
                    break;
                case 'T':
                    countT++;
                    break;
            }

            if (countA >= requiredA && countC >= requiredC && countG >= requiredG && countT >= requiredT) {
                validPasswords++;
            }
        }
        System.out.println(validPasswords);
    }
}
