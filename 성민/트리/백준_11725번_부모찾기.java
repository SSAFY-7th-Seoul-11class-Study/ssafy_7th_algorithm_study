package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


import java.util.StringTokenizer;

public class 백준_11725번_부모찾기 {
	
	static int N;
	static ArrayList<Integer>[]tree;
	static boolean visited[];
	static int parent[];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		
		tree=new ArrayList[N+1];
		visited=new boolean[N+1];
		parent = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			tree[i]=new ArrayList<>(); // 초기화
		}
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int num1= Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			tree[num1].add(num2);
			tree[num2].add(num1);
		}// 연결
		
		dfs(1); //root가 1이므로 1을 넣어준다.
		
		for(int i=2;i<=N;i++) {
			sb.append(parent[i] +"\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		
		for(int i=0;i<tree[start].size();i++) {
			int temp=tree[start].get(i);
			
			if(visited[temp]==false) { // 이미 방문한거 아니라면 부모배열에
				parent[temp]=start;
				dfs(temp);
			}
			
		}
	}
}
