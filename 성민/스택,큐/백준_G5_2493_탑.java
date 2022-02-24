package day0207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_G5_2493_탑 {

	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		Stack<int[]> stack = new Stack<int[]>();
		
		N= Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			int height=Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1]>=height) {
					sb.append(stack.peek()[0]+" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i+1,height});
		}
		
		bw.write(sb+"\n");
		
		br.close();
		bw.close();
		}
		
		
}


