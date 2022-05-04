package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_S3_1003_피보나치함수 {

	static int T;
	static int N;
	static Integer[][] dp=new Integer[41][2];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

		dp[0][0]=1; // N=0일 때 0호출 횟수
		dp[0][1]=0;
		dp[1][0]=0;
		dp[1][1]=1;
		
		T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			N=Integer.parseInt(br.readLine());
			fibo(N);
			sb.append(dp[N][0]+" "+dp[N][1]).append("\n");
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static Integer[] fibo(int N) {
		if(dp[N][0]==null || dp[N][1]==null) {
			dp[N][0]=fibo(N-1)[0]+fibo(N-2)[0];
			dp[N][1]=fibo(N-1)[1]+fibo(N-2)[1];
		}
		
		return dp[N];
	}

}
