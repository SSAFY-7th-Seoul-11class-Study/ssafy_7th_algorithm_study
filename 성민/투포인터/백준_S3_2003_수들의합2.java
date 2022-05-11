package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S3_2003_수들의합2 {

	static int N,M;
	static int arr[];
	static int ans;
	static int sum;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		int end=0;
		int sum=arr[0];
		while(true) {
			if(sum==M) {
				sum-=arr[start++];
				sum+=arr[++end];
				ans++;
				
			}else if(sum<M) {
				sum+=arr[++end];
			}else {
				sum-=arr[start++];
			}
			
			if(end==N) {
				break;
			}
			
		}
		bw.write(ans+"\n");
		br.close();
		bw.close();
	}

}
