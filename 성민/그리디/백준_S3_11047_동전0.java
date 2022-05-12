package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_S3_11047_동전0 {
	static int N,K;
	static Integer money[];
	static int cnt;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		money= new Integer[N];
		cnt=0;
		for(int i=0;i<N;i++) {
			money[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(money,Collections.reverseOrder()); //그냥 반복문 편하게하려고 내림차

		for(int i=0;i<N;i++) {
			if(K<money[i]) 
				continue;
			else {
				
				cnt+=K/money[i];
				
				K%=money[i];
			}
		}
		bw.write(cnt+"\n");
		br.close();
		bw.close();
	}

}
