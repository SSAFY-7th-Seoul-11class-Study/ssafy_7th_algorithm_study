package 정렬.개인문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_S4_1026_보물 {
	static int N;
	static int arr[];
	static Integer brr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		brr=new Integer[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			
			brr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		Arrays.sort(brr,Collections.reverseOrder());
		
		int ans=0;
		
		for(int i=0;i<N;i++) {
			ans+=arr[i]*brr[i];
		}
		bw.write(ans+"\n");
		
		br.close();
		bw.close();
	}

}
