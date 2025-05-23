import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double sum = 0;
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				sum+=tmp;
			}
			System.out.println("#" + i + " " + Math.round(sum/10));
		}
		
		br.close();
	}
}
