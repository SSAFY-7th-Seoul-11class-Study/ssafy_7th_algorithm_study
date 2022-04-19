package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_G4_10830_행렬제곱 {
	static int N;
	static long B;
	static int map[][],result[][];
	static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		B=Long.parseLong(st.nextToken());
		
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken())%1000; // 1000 나눠서 해줘야됨(1제곱경우때문)
			}
		}
		
		result=divide(map,B);
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				sb.append(result[r][c]+" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	public static int[][] divide(int[][]map,long B){
		if(B==1) {
			return map;
		}
		if(B%2==1) {
			int[][] temp= divide(map,B/2);
			return calculation(calculation(temp,temp),map);
			
		}else {
			int[][] temp=divide(map,B/2);
			return calculation(temp,temp);
		}
	}
	
	public static int[][] calculation(int [][] arr1,int[][] arr2){
		int[][] newmap=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					newmap[i][j]+=arr1[i][k]*arr2[k][j];
				}
				newmap[i][j]%=1000;
			}
		}
		return newmap;
	}
}
