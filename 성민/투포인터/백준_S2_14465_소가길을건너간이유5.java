package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S2_14465_소가길을건너간이유5 {
	
	static int N,K,B;
	static int arr[];
	static int sum[];
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken()); //1번부터 N번까지 번호붙은 횡ㄷㄴ보도
		K=Integer.parseInt(st.nextToken()); //연속 k개 신호등
		B=Integer.parseInt(st.nextToken()); // 고장난 신호등 개수
		
		arr=new int[N+1];
		sum=new int[N+1];
		
		
		for(int i=0;i<B;i++) {
			arr[Integer.parseInt(br.readLine())]=1; // 고장난 신호등
		}
		
		int cnt=0;
		
		for(int i=1;i<=K;i++) {
			if(arr[i]==1) {
				cnt++;
			}
		}
		sum[K]=cnt;
		int res=cnt;
		
		for(int i=K+1;i<=N;i++) {
			int temp=sum[i-1];
			if(arr[i]==1) {
				temp++;
			}
			if(arr[i-K]==1) {
				temp--;
			}
			
			sum[i]=temp;
			res=Math.min(res, temp);
		}
		
		bw.write(res+"\n");
		br.close();
		bw.close();
	}

}
