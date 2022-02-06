package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1158_요세푸스문제 {

	static int n,k;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		int cnt =1;
		sb.append('<');
		while(!queue.isEmpty()) {
			if(cnt!=k) {
				queue.offer(queue.poll());
				cnt++;
			}else {
				sb.append(queue.poll()).append(", ");
				cnt=1;
			}
		}
		String result = sb.substring(0,sb.length()-2);
		
		bw.write(result+">");
		
		br.close();
		bw.close();
	}

}
