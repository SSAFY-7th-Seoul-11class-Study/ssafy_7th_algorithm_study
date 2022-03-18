package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 백준_S5_10989_수정렬하기3 {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			bw.write(arr[i]+"\n");
		}
		
		br.close();
		bw.close();

	}

}
