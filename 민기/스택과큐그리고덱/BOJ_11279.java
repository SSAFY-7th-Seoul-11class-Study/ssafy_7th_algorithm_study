
package 민기.스택과큐그리고덱;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int inputNum = Integer.parseInt(br.readLine());
			if(inputNum != 0){
				queue.add(inputNum);
			} else if(queue.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(queue.poll());
			}
		}
	}
}
