package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S4_10816_숫자카드2 {
	static int N,M;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		cnt=new int[20000001];
		
		N=Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			cnt[tmp+10000000]++;
		}
		
		M=Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<M;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			sb.append(cnt[tmp+10000000]+" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	}

}
