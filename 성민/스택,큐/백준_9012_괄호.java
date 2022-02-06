package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9012_괄호 {
	static int T;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		
		T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			Stack<Character>stack = new Stack<>();
			String str= br.readLine();
			
			for(int i=0;i<str.length();i++) {
				
				if(str.charAt(i)=='(') {
					stack.push(str.charAt(i));
				}
				if(stack.isEmpty() && str.charAt(i)==')') {
					stack.push(str.charAt(i));
					break;
				}
				if(!stack.isEmpty() && str.charAt(i)==')') {
					stack.pop();
				}
				
			}
			if(!stack.isEmpty()) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
			
		}
		System.out.println(sb);
		
	}

}
