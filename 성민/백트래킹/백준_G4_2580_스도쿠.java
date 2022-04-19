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
 * 백트래킹
 * 유망하지 않은거 : 가로 세로에 겹치고 ,3x3 박스에 겹치는 지 확인
 */
public class 백준_G4_2580_스도쿠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] map;
	public static void main(String[] args) throws IOException {
		
		map=new int[9][9];
		
		for(int r=0;r<9;r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0;c<9;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
 			}//맵
		}
		
		dfs(0,0);

	}
	
	public static void dfs(int row,int col) {
		
		if(col==9) { //열 다 했다는 거니까 다음 행
			dfs(row+1,0);
			return;
		}
		if(row==9) {
			// 다 탐색한 경우
			StringBuilder sb = new StringBuilder();
			for(int r=0;r<9;r++) {
				for(int c=0;c<9;c++) {
					sb.append(map[r][c]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
			System.exit(0);
		}
		
		if(map[row][col]==0) { //빈칸에 넣을값 찾기
			for(int i=1;i<=9;i++) { //1부터 9까지
				if(check(row,col,i)) {
					map[row][col]=i;
					dfs(row,col+1);
				}
			}
			map[row][col]=0;
			return;
		}
		dfs(row,col+1); //빈 칸 아닌경우
	}
	
	public static boolean check(int row,int col,int num) {
		//같은 열에 무슨 숫자가 비었나
		for(int c=0;c<9;c++) {
			if(map[row][c]==num) {
				return false;
			}
		}
		
		//같은 행
		for(int r=0;r<9;r++) {
			if(map[r][col]==num) {
				return false;
			}
		}
		
		//3x3 
		int nrow=(row/3)*3;
		int ncol=(col/3)*3;
		
		for(int r=nrow;r<nrow+3;r++) {
			for(int c=ncol;c<ncol+3;c++) {
				if(map[r][c]==num) {
					return false;
				}
			}
		}
		
		return true;
	}

}
