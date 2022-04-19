package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S2_1012_유기농배추 {
	static int T;
	static int M,N,K; //가로 세로 배추 위치개수
	static int map[][];
	static boolean[][] visited;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st=new StringTokenizer(br.readLine()," ");
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			map=new int[M][N];
			visited=new boolean[M][N];
			ans=0;
			//배추 입력
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int r=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				map[r][c]=1;
			}
			for(int r=0;r<M;r++) {
				for(int c=0;c<N;c++){
					if(map[r][c]==1 && !visited[r][c]) {
						dfs(r,c);
						ans++;
					}
				}
			}
			bw.write(ans+"\n");
		}//테케
		br.close();
		bw.close();
	}
	public static void dfs(int r,int c) {
		visited[r][c]=true;
		
		for(int i=0;i<4;i++) {
			int nx= r+dx[i];
			int ny= c+dy[i];
			
			if(isIN(nx,ny)) {
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
	
	public static boolean isIN(int nx,int ny) {
		return 0<=nx && 0<=ny && nx<M && ny<N;
	}
}
