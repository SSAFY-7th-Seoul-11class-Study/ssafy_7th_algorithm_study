package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S3_3273_두수의합 {

	static int n;
	static int x;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		arr=new int[n];
		
		st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		x=Integer.parseInt(br.readLine());
		
		int cnt=0;
		
		int left=0;
		int right=arr.length-1;
		
		while(left<right) {
			int sum=arr[left]+arr[right];
			
			if(sum<=x) {
				left++;
			}else {
				right--;
			}
			
			if(sum==x) {
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		br.close();
		bw.close();
	}

}
