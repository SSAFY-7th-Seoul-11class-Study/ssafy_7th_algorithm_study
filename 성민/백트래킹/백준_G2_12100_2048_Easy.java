package 백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author Me1st
 * BFS/DFS 
 * 문제서 5번제한 있음 경우의수 기껏해야 1300~1400? 걍 완탐때리자
 * 블록 이동방향이랑 탐색방향이랑 반대
 * 블록 합치는 거 때문에 블록 변수 두개 필요(이전거랑 새로운거)
 */
public class 백준_G2_12100_2048_Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,Max;
	static int[][] map;
	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
	public static void main(String[] args) throws IOException{
		N=Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0;c<N;c++) {
				map[r][c]=  Integer.parseInt(st.nextToken());
				Max =Math.max(Max, map[r][c]);
			}
		}//맵
		
		dfs(map,0);
		bw.write(Max+"\n");
		br.close();
		bw.close();
	}
	
	public static void dfs(int [][]map,int turn) {
		
		if(turn==5) {
			return;
		}
		
		for(int d=0;d<deltas.length;d++) {
			int [][] moved =move(map,d);
			dfs(moved,turn+1);
		}
	}
	
	// d방향으로 이동 시킨 상황을 새로운 맵으로 만듬
	public static int[][] move(int [][]map, int d){
		int  [][] newmap =new int[N][N];
		
		if(d==0) { // 상 -> 아래로 탐색
			for(int c=0;c<N;c++) {
				int nextIdx=0, before=-1;
				for(int r=0;r<N;r++) {
					
					if(map[r][c]==0) {
						continue;
					}
					
					if(map[r][c]==before) {
						newmap[nextIdx-1][c]=map[r][c]*2;
						before=-1;
						Max=Math.max(Max, newmap[nextIdx-1][c]);
					}else {
						newmap[nextIdx++][c]=map[r][c];
						before=map[r][c];
					}
				}
			}
		}else if(d==1) { // 하 -> 아래서 위로탐색
			for(int c=0;c<N;c++) {
				int nextIdx=N-1, before=-1;
				for(int r=N-1;r>=0;r--) {
					
					if(map[r][c]==0) {
						continue;
					}
					
					if(map[r][c]==before) {
						newmap[nextIdx+1][c]=map[r][c]*2;
						before=-1;
						Max=Math.max(Max, newmap[nextIdx+1][c]);
					}else {
						newmap[nextIdx--][c]=map[r][c];
						before=map[r][c];
					}
				}
			}
		}else if(d==2) { // 좌 -> 좌에서 우로 탐색
			for(int r=0;r<N;r++) {
				int nextIdx=0, before=-1;
				for(int c=0;c<N;c++) {
					
					if(map[r][c]==0) {
						continue;
					}
					
					if(map[r][c]==before) {
						newmap[r][nextIdx-1]=map[r][c]*2;
						before=-1;
						Max=Math.max(Max, newmap[r][nextIdx-1]);
					}else {
						newmap[r][nextIdx++]=map[r][c];
						before=map[r][c];
					}
				}
			}
		}else { // 우 -> 우에서 좌로 탐색
			for(int r=0;r<N;r++) {
				int nextIdx=N-1, before=-1;
				for(int c=N-1;c>=0;c--) {
					
					if(map[r][c]==0) {
						continue;
					}
					
					if(map[r][c]==before) {
						newmap[r][nextIdx+1]=map[r][c]*2;
						before=-1;
						Max=Math.max(Max, newmap[r][nextIdx+1]);
					}else {
						newmap[r][nextIdx--]=map[r][c];
						before=map[r][c];
					}
				}
			}
		}
		return newmap;
	}

}
