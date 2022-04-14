package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S3_2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int white=0;
	static int blue=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}//맵
		
		go(0,0,N);
		
		bw.write(white+"\n");
		bw.write(blue+"\n");
		
		br.close();
		bw.close();
		
	}
	public static void go(int r,int c,int size) {
		
		if(colorCheck(r,c,size)) {
			if(map[r][c]==0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		
		int newSize=size/2;
		
		go(r,c,newSize); //2사분면
		go(r,c+newSize,newSize); //1 사분면
		go(r+newSize,c,newSize);//3사분면
		go(r+newSize,c+newSize,newSize); //4 사분면
	}
	
	public static boolean colorCheck(int r,int c,int size) {
		int color=map[r][c]; //맨 처음 값을 기준으로 함
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
