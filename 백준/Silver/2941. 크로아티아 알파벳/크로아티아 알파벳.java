import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] strs = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String s = sc.nextLine();

        for(int i=0; i<strs.length; i++) {
            if(s.contains(strs[i])) {
                s = s.replace(strs[i], "/");
            }
        }

        System.out.print(s.length());
    }
}
