package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S3_2606_바이러스 {
	
	static int map[][];
	static boolean visited[];
	static int n,m;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		map=new int[n+1][n+1];
		visited=new boolean[n+1];
		
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=map[b][a]=1;
		}
		
		bw.write(dfs(1)+"\n");
		br.close();
		bw.close();

	}
	
	public static int dfs(int num) {
		visited[num]=true;
		
		for(int i=1;i<=n;i++) {
			if(map[num][i]==1 &&visited[i]==false) {
				count++;
				dfs(i);
			}
		}
		return count;
	}

}
