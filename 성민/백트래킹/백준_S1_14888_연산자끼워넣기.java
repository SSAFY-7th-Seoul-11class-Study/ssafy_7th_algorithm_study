package 백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S1_14888_연산자끼워넣기 {
	static int N;
	static int arr[];
	static int oper[];
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		oper=new int[4];
		
		for(int i=0;i<4;i++) { // + ,-, x, / 순
			oper[i]=Integer.parseInt(st.nextToken());
		}
		
		DFS(arr[0],1);
		bw.write(max+"\n");
		bw.write(min+"\n");
		br.close();
		bw.close();
	}
	
	 public static void DFS(int num,int cnt) {
		 
		 if(cnt==N) {
			 max = Math.max(max, num);
			 min=Math.min(min, num);
			 return;
		 }
		 
		 for(int i=0;i<4;i++) {
			 if(oper[i]>0) {
				 oper[i]--;
				 
				 if(i==0) {
					 DFS(num+arr[cnt],cnt+1);
				 }else if(i==1) {
					 DFS(num-arr[cnt],cnt+1);
				 }else if(i==2) {
					 DFS(num*arr[cnt],cnt+1);
				 }else if(i==3) {
					 DFS(num/arr[cnt],cnt+1);
				 }
				 
				 oper[i]++; //원상복구
			 }
		 }
	 }

}
