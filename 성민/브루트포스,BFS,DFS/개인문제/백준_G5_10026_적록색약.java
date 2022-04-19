package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_G5_10026_적록색약 {
	static int N;
	static char[][] map;
	static int dx[]= {-1,0,0,1};
	static int dy[]= {0,1,-1,0}; //상우좌하
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		visited=new boolean[N][N];
		for(int r=0;r<N;r++) {
			String str= br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c]= str.charAt(c);
			}
		}// 맵정리
		
		//평범한 사람
		int normal_cnt=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++ ) {
				if(!visited[r][c]) {
					dfs(r,c);
					normal_cnt++;
				}
			}
		}
		// 색맹
		int cnt=0;
		visited=new boolean[N][N]; //방문처리 초기화
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]=='G') {
					map[r][c]='R';
				}
			}
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++ ) {
				if(!visited[r][c]) {
					dfs(r,c);
					cnt++;
				}
			}
		}
		
		bw.write(normal_cnt+" "+cnt+"\n");
		br.close();
		bw.close();
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		char tmp= map[x][y];
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) {
				continue;
			}
			
			if(!visited[nx][ny] && map[nx][ny]==tmp) {
				dfs(nx,ny);
			}
		}
	}
}
