import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			int n = sc.nextInt();
            sc.nextLine();
            
            char[][] board = new char[8][8];
            for(int i=0; i<8; i++) {
                String line = sc.nextLine();
                board[i] = line.toCharArray();
            }
            
            int count = 0;
            
            for(int i=0; i<8; i++) {
                for(int j=0; j<= 8-n; j++) {
                    boolean isPal = true;
                    for(int k=0; k<n/2; k++) {
                        if(board[i][j+k] != board[i][j+n-1-k]) {
                            isPal = false;
                            break;
                        }
                    }
                    if(isPal) count++;
                }
            }
            
            for(int j=0; j<8; j++) {
                for(int i=0; i<=8-n; i++) {
                    boolean isPal = true;
                    for(int k=0; k<n/2; k++) {
                        if(board[i+k][j] != board[i+n-1-k][j]) {
                            isPal = false;
                            break;
                        }
                    }
                    if (isPal) count++;
                }
            }
            
            System.out.println("#" + test_case + " " + count);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}