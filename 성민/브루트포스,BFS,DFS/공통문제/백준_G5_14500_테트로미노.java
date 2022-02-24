package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_G5_14500_테트로미노 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int maxSum;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N= Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		
		for(int r=0;r<N;r++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}//맵정리
		
		visited=new boolean[N][M];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				visited[r][c]=true;
				// ㅜ를 빼고 DFS
				dfs(r,c,1,map[r][c]);
				// ㅜ 별도 처리
				maxSum=Math.max(getLast(r,c), maxSum);
				visited[r][c] =false;
			}
		}
		bw.write(maxSum+"\n");
		br.close();
		bw.close();
	}
	
	public static void dfs(int row,int col, int cnt, int sum) {
		if(cnt==4) {
			maxSum= Math.max(maxSum, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = row +dx[i];
			int ny = col+dy[i];
			
			if(isIn(nx,ny) && !visited[nx][ny]) {
				visited[nx][ny]=true;
				dfs(nx,ny,cnt+1,sum+map[nx][ny]);
				visited[nx][ny]=false;
			}
		}
	}
	
	public static int getLast(int row,int col) {
		int base=map[row][col];
		int cnt =0; //사방탐색 횟수
		int min=Integer.MAX_VALUE;
		//중심점 기준으로 사방
		for(int i=0;i<4;i++) {
			int nx=row +dx[i];
			int ny=col +dy[i];
			if(isIn(nx,ny)) {
				cnt++;
				base+=map[nx][ny];
				min =Math.min(min, map[nx][ny]);
			}
		}
		//4방 탐색 다 성공하면 4군데중 최소값 하나 빼기
		if(cnt==4) {
			return base-min;
		}else if(cnt==3) {
			return base;
		}
		else {
			return -1;
		}
	}
	public static boolean isIn(int r, int c) {
		return 0 <=r && r<N && 0<=c && c<M;
	}

}
