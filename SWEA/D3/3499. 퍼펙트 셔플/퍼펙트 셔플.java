import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] cards = br.readLine().split(" ");
            
            int mid = (N + 1) / 2;
            
            sb.append("#").append(tc).append(" ");
            
            for(int i=0; i<N-mid; i++) {
                sb.append(cards[i]).append(" ");
                sb.append(cards[mid + i]).append(" ");
            }
            
            if(N % 2 == 1) {
                sb.append(cards[mid-1]).append(" ");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
