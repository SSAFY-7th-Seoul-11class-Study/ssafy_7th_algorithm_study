package 위상정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_G2_1766_문제집 {
	
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1];
		
		ArrayList<ArrayList<Integer>> list =new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			arr[b]++; // b 보다 먼저 풀어야 하는 문제 개수
		}
		
		PriorityQueue<Integer> q =new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			if(arr[i]==0) {
				q.offer(i);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		while(!q.isEmpty()) {
			int now=q.poll();
			sb.append(now+" ");
			
			// now랑 연결문제 찾기
			for(int next:list.get(now)) {
				arr[next]--; //now에 해당되는 문제 먼저 풀어서 next보다 먼저 풀 개수 줄어듬
				
				//먼저 풀 문제 없는 경우 큐에 삽입
				if(arr[next]==0) {
					q.offer(next);
				}
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
