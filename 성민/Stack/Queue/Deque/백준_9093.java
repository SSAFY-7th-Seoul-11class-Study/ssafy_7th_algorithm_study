package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 백준_9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> st = new Stack<Character>();
		
		int n= Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)==' ') {
					while(!st.empty()) {
						bw.write(st.pop());
					}
					bw.write(" ");
				}else {
					st.push(s.charAt(j));
				}
			}
			while(!st.empty()) {
				bw.write(st.pop());
			}
		
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
