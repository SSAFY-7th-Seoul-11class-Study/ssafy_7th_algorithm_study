package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 백준_S1_2667_단지번호붙이기 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int cnt=0;
	static int value_cnt;
	static LinkedList<Integer> list=new LinkedList<>();
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited=new boolean[N][N];
		
		for(int r=0;r<N;r++) {
			String str= br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c]=str.charAt(c);
			}
		}//맵완성
		//탐색
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]=='1' && !visited[r][c]) {
					value_cnt=0;
					dfs(r,c);
					cnt++;
					list.add(value_cnt);
				}
			}
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			sb.append(list.poll()+"\n");
			i--;
		}
		bw.write(cnt+"\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void dfs(int r,int c) {
		value_cnt++;
		visited[r][c]=true;
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(isIn(nr,nc)) {
				if(map[nr][nc]=='1' && !visited[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
		
	}
	
	public static boolean isIn(int nr,int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<N;
	}

}
