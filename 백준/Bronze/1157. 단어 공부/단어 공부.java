import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine().toLowerCase();
		int[] cnt = new int[26];
		for(int i=0; i<st.length(); i++) {
		    cnt[st.charAt(i)-'a']++;
		}
		
		int max = 0;
		char answer = '?';
		
		for(int i=0; i<cnt.length; i++) {
		    if(max<cnt[i]) {
		        max = cnt[i];
		        answer = (char)(i+'A');
		    } else if(max == cnt[i]) {
		        answer = '?';
		    }
		}
		
		System.out.print(answer);
	}
}