import java.io.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws Exception {
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
		    if(check()) {
		        count++;
		    }
		}
		
		System.out.print(count);
	}
	
	public static boolean check() throws Exception {
	    boolean[] arr = new boolean[26];
	    int prev = 0;
	    String st = br.readLine();
	    
	    for(int i=0; i<st.length(); i++) {
	        int now = st.charAt(i);
	        if(prev != now) {
	            if(!arr[now - 'a']) {
	                arr[now-'a'] = true;
	                prev = now;
	            } else {
	                return false;
	            }
	        }
	    }
	    
	    return true;
	}
}