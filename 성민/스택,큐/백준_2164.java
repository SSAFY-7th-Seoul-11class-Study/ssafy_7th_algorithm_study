package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class 백준_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Integer> q= new LinkedList<Integer>();
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			q.pop();
			q.add(q.pop());
		}
		bw.write(q.peek()+"\n");
		
		br.close();
		bw.close();
	}

}
