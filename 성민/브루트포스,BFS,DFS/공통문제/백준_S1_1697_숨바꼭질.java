package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S1_1697_숨바꼭질 {
	
	static int N,K;
	static int ans=1;
	static int[] depth = new int[100001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		
		if(N==K) {
			bw.write(0+"\n");
		}else {
			bfs(N);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		depth[num]=1; // 시작 노드
		
		while(!queue.isEmpty()) {
			int tmp=queue.poll();
			
			for(int i=0;i<3;i++) {
				int next;
				
				if(i==0) {
					next=tmp+1;
				}else if(i==1) {
					next=tmp-1;
				}else {
					next=tmp*2;
				}
				
				if(next ==K) {
					sb.append(depth[tmp]+"\n");
					return;
				}
				
				if(next>=0 && next<depth.length && depth[next]==0) {
					queue.add(next);
					depth[next]=depth[tmp]+1;
				}
			}
			
			
		}
		
	}

}
