package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S4_10025_게으른백곰 {
	
	static int N,K;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[1000001];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int g=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			
			arr[x]=g; //각 위치마다 무게 값
		}
		
		int sum=0;
		int ans=0;
		
		int window=2*K+1;
		
		for(int i=0;i<=1000000;i++) {
			if(i>=window) {
				sum-=arr[i-window];
			}
			sum+=arr[i];
			
			if(sum>ans) {
				ans=sum;
			}
		}
		
		bw.write(ans+"\n");
		br.close();
		bw.close();
		
		
	}

}
