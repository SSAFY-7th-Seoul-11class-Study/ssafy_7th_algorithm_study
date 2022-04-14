package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버_S4_11582_치킨TOPN {
	static int N;
	static int k;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N=Integer.parseInt(br.readLine());
		
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}// 데이터 인
		
		k=Integer.parseInt(br.readLine());
		
		int size= arr.length/k;
		int s=0;
		for(int i=0;i<k;i++) {
			Arrays.sort(arr,s,s+size);
			s+=size;
		}
		
		for(int i : arr) {
			bw.write(i+" ");
		}
		bw.write("\n");
		
		br.close();
		bw.close();
		
		
	}
	
	


}
