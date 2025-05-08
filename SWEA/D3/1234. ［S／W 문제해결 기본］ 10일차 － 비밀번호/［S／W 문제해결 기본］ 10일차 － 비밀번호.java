import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T= 10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            /////////////////////////////////////////////////////////////////////////////////////////////
            int len = sc.nextInt();
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
             
            for(int i=0; i<input.length(); i++) {
                char c = input.charAt(i);
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
             
            StringBuilder sb = new StringBuilder();
            for(char ch : stack) {
                sb.append(ch);
            }
             
            System.out.println("#" + test_case + " " + sb.toString());
            /////////////////////////////////////////////////////////////////////////////////////////////
 
        }
    }
}