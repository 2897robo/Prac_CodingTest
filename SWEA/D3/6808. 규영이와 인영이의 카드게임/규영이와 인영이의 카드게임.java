// SWEA 6808 - 규영이와 인영이의 카드게임

import java.util.*;
import java.io.*;

public class Solution {

    static int[] gyuCard;
    static int[] inCard;
    static int[] inCardOrder;
    static boolean[] isSelected;
    static int winCount;
    static int loseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            gyuCard = new int[9];
            inCard = new int[9];
            inCardOrder = new int[9];
            isSelected = new boolean[9];

            boolean[] cardCheck = new boolean[19];

            for(int i=0; i<9; i++) {
                gyuCard[i] = Integer.parseInt(st.nextToken());
                cardCheck[gyuCard[i]] = true;
            }

            int idx = 0;
            for(int i=1; i<=18; i++) {
                if(!cardCheck[i]) {
                    inCard[idx++] = i;
                }
            }

            winCount = 0;
            loseCount = 0;

            permuteInCard(0);

            sb.append(winCount).append(" ").append(loseCount).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void permuteInCard(int cnt) {
        if(cnt == 9) {
            playGame();
            return;
        }

        for(int i=0; i<9; i++) {
            if(isSelected[i]) continue;

            inCardOrder[cnt] = inCard[i];
            isSelected[i] = true;

            permuteInCard(cnt + 1);

            isSelected[i] = false;
        }
    }


    static void playGame() {
        int gyuSum = 0;
        int inSum = 0;

        for(int i=0; i<9; i++) {
            if(gyuCard[i] > inCardOrder[i]) {
                gyuSum += gyuCard[i] + inCardOrder[i];
            } else {
                inSum += gyuCard[i] + inCardOrder[i];
            }
        }

        if(gyuSum > inSum) {
            winCount++;
        } else if(gyuSum < inSum) {
            loseCount++;
        }
    }
}
