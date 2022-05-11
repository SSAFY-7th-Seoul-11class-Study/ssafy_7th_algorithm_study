package 투포인터;

import java.util.*;
import java.io.*;
public class 백준_G4_2096_내려가기 {
	
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		
		int[] maxsum=new int[3];
		int[] minsum=new int[3];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			int n3=Integer.parseInt(st.nextToken());
			
			if(i==0) {
				maxsum[0]=minsum[0]=n1;
				maxsum[1]=minsum[1]=n2;
				maxsum[2]=minsum[2]=n3;
			}else {
				int temp1=maxsum[0];
				int temp2=maxsum[2];
				maxsum[0]=Math.max(maxsum[0], maxsum[1])+n1;
				maxsum[2]=Math.max(maxsum[1],maxsum[2])+n3;
				maxsum[1]=Math.max(Math.max(temp1, maxsum[1]),temp2)+n2;
				
				int temp3=minsum[0];
				int temp4=minsum[2];
				minsum[0]=Math.min(minsum[0], minsum[1])+n1;
				minsum[2]=Math.min(minsum[2], minsum[1])+n3;
				minsum[1]=Math.min(Math.min(minsum[1], temp3), temp4)+n2;
			}
		}
		
		bw.write(Math.max(Math.max(maxsum[0], maxsum[1]),maxsum[2])+" ");
		bw.write(Math.min(Math.min(minsum[0], minsum[1]),minsum[2])+"\n");
		br.close();
		bw.close();
	}

}
