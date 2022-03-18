package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_S5_10989_수정렬하기3_다른풀이 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[10001];
		
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<10001;i++) {
			while(arr[i]>0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
	}

}
