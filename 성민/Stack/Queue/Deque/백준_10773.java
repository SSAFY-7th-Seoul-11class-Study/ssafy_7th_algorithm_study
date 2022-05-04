package Stack.Queue.Deque;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class 백준_10773 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> s = new Stack<Integer>();
		
		int k = Integer.parseInt(br.readLine()); // 테케
		int sum=0;
		while(k>0) {
			int num= Integer.parseInt(br.readLine());
			
			if(num>0) {
				s.push(num);
			}else if(num==0) {
				s.pop();
			}
			k--;
		}
		while(!s.empty()) {
			sum+=s.pop();
		}
		bw.write(sum+"\n");
		
		br.close();
		bw.close();
	}

}
