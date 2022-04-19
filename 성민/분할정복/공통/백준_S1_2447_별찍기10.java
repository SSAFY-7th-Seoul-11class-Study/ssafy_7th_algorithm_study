package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_S1_2447_별찍기10 {
	static char[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		arr= new char[N][N];
		
		go(0,0,N,false);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString()+"\n");
		br.close();
		bw.close();
	}
	
	public static void go(int x,int y,int N,boolean blank){
		//공백
		if(blank) {
			for(int i=x;i<x+N;i++) {
				for(int j=y;j<y+N;j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		
		// 더이상 분할 X
		if(N==1) {
			arr[x][y]='*';
			return;
		}
		
		int size=N/3;
		int count=0;
		
		for(int i=x;i<x+N;i+=size) {
			for(int j=y;j<y+N;j+=size) {
				count++;
				if(count==5) { //공백칸
					go(i,j,size,true);
				}else {
					go(i,j,size,false);
				}
			}
		}
	}

}
