package greedy;

/**
 * 아무생각 없이 풀었다가 틀렸던 문제
 * 그냥 n=2 m=30 그리고 숫자의 최댓값인 1,000,000을 하면 int 범위가 넘어서서 틀렸다고 나옴
 * 문제 풀 때 int로 할지 long 할지 생각도 하자!
 * 그냥 array로 풀어봤는데 풀면서도 TLE날 줄 알았는데 안남.
 * 
 * 그래도 Queue에 넣을 때마다 정렬해주는 우선순위 큐가 시간이 더 좋지 않을까 해서 시도
 * 배열 다 더하는 Arrays.stream(배열명).sum() 알게됨
 * Array로 했을때 시간 684ms 우선순위 큐 128ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S2_15903_카드합체놀이 {
	static int N,M;
	static long arr[];
	static long answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		N= Integer.parseInt(st.nextToken()); // N장의 카드
		M= Integer.parseInt(st.nextToken()); //M번의 합체
		
		Queue<Long> queue = new PriorityQueue<>();
		st= new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			queue.offer(Long.parseLong(st.nextToken()));
		}
		
		while (M>0) {
			long num1=queue.poll();
			long num2 = queue.poll();
			
			long sum= num1+num2;
			queue.offer(sum);
			queue.offer(sum);
			
			M--;
		}
		for(long i : queue) {
			answer+=i;
		}

		
		bw.write(answer+"\n");
		br.close();
		bw.close();
	}

}
