package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_2161_카드1 {

	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		n= Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			sb.append(queue.poll()).append(" ");
			if(!queue.isEmpty()) {
				queue.add(queue.poll());
			}
		}
		System.out.println(sb);
	}

}
