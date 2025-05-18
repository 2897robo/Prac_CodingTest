import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			int testNum = Integer.parseInt(br.readLine());
            
            char[][] board = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                board[i] = line.toCharArray();
            }

            int maxLen = 0;

            for (int len = 100; len >= 1; len--) {
                boolean found = false;

                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - len; j++) {
                        boolean isPal = true;
                        for (int k = 0; k < len / 2; k++) {
                            if (board[i][j + k] != board[i][j + len - 1 - k]) {
                                isPal = false;
                                break;
                            }
                        }
                        if (isPal) {
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }

                if (!found) {
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i <= 100 - len; i++) {
                            boolean isPal = true;
                            for (int k = 0; k < len / 2; k++) {
                                if (board[i + k][j] != board[i + len - 1 - k][j]) {
                                    isPal = false;
                                    break;
                                }
                            }
                            if (isPal) {
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                }

                if (found) {
                    maxLen = len;
                    break;
                }
            }

            System.out.println("#" + testNum + " " + maxLen);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}
