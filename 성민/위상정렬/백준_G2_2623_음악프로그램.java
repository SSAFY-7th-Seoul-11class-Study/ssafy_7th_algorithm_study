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

public class 백준_G2_2623_음악프로그램 {
	
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
 		N=Integer.parseInt(st.nextToken()); //가수 인원
 		M=Integer.parseInt(st.nextToken()); // 보조pd 인원
 		
 		ArrayList<ArrayList<Integer>> list =new ArrayList<>();
 		
 		for(int i=0;i<=N;i++) {
 			list.add(new ArrayList<>());
 		}
 		
 		int[] node=new int[N+1];
 		
 		for(int i=0;i<M;i++) {
 			st=new StringTokenizer(br.readLine()," ");
 			
 			int num=Integer.parseInt(st.nextToken());
 			int before=Integer.parseInt(st.nextToken());
 			
 			for(int j=1;j<num;j++) {
 				int singer =Integer.parseInt(st.nextToken());
 				list.get(before).add(singer);
 				node[singer]++;
 				
 				before=singer;
 			}
 		}
 		String ans=topoSort(list,node,N);
 		
 		bw.write(ans);
 		br.close();
 		bw.close();
	}
	
	public static String topoSort(ArrayList<ArrayList<Integer>> list, int[] node,int N) {
		Queue <Integer> q =new LinkedList<>();
		ArrayList<Integer> res=new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			if(node[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now=q.poll();
			res.add(now);
			
			for(int next : list.get(now)) {
				node[next]--;
				
				if(node[next]==0) {
					q.offer(next);
				}
			}
		}
		
		if(res.size()!=N) {
			return "0\n";
		}
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<res.size();i++) {
			sb.append(res.get(i)+"\n");
		}
		return sb.toString();
	}

}
