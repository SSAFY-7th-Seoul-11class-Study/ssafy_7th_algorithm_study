package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_S4_1021_회전하는큐 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count=0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수
		
		for(int i=1;i<=N;i++) {
			deque.offer(i);
		}
		
		int[] seq = new int [M];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) {
			seq[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<M;i++) {
			int target_idx=deque.indexOf(seq[i]); //뽑으려는 숫자 인덱스 찾기
			int half_idx;
			
			if(deque.size()%2==0) {
				half_idx=deque.size()/2-1;
			}else {
				half_idx=deque.size()/2;
			}
			if(target_idx<=half_idx) {
				for(int j=0;j<target_idx;j++) {
					int temp=deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {
				for(int j=0;j<deque.size()-target_idx;j++) {
					int temp=deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			
			deque.pollFirst();
		}
		System.out.println(count);
		
		
	}

}
