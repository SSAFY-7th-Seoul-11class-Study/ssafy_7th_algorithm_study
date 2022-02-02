package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		int time = 0;
		int bw=0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<w; i++) {
			q.add(0);
		}
		while(!q.isEmpty()) {
			time++;
			bw-=q.poll();
			if(!queue.isEmpty()) {
				if(queue.peek()+bw<=L) {
					bw+=queue.peek();
					q.offer(queue.poll());
				} else {
					q.offer(0);
				}
			}
		}
		System.out.println(time);

	}

}
