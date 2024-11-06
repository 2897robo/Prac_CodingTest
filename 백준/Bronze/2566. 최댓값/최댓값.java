import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[9][9];
        int max = 0, h = 0, w = 0;

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= max) {
                    max = a[i][j];
                    h = i+1;
                    w = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.print(h + " " + w);
    }
}