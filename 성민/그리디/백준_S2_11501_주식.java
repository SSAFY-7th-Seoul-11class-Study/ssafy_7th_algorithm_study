package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S2_11501_주식 {

	static int T, N;
	static long[] arr;
	static long answer;
	static long sum;
	static long cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			sum=0;
			long max=Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new long[N];

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int k=arr.length-1;k>=0;k--) {
				if(max<arr[k])
					max=arr[k];
				if(max>arr[k])
					sum+=max-arr[k];
					
			}
			
			bw.write(sum+"\n");
		}//tc
		br.close();
		bw.close();
	}

}
