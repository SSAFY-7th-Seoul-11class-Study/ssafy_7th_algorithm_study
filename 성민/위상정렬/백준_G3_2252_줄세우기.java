package 위상정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_G3_2252_줄세우기 {
	static int N,M;
	static int table[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		table=new int[N+1];
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			table[b]++;
		}
		
		bw.write(toposort(table,arr));
		br.close();
		bw.close();
		
		
	}
	public static String toposort(int[] table,ArrayList<Integer>[] arr) {
		Queue<Integer> q=new LinkedList<>();
		sb=new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			if(table[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node=q.poll();
			sb.append(node+" ");
			
			for(int idx : arr[node]) {
				table[idx]--;
				
				if(table[idx]==0) {
					q.offer(idx);
				}
			}
		}
		
		return sb.toString();
	}

}
