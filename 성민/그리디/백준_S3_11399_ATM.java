package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S3_11399_ATM {
	static int N;
	static int time[];
	static int sum,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine()," ");
		sum=0;
		cnt=0;
		time = new int[N];
		for(int i=0;i<N;i++) {
			time[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		for(int i=0;i<N;i++) {
			System.out.println(time[i]);
			sum+=cnt+time[i];
			cnt+=time[i];
		}
		bw.write(sum+"\n");
		br.close();
		bw.close();
	}

}
