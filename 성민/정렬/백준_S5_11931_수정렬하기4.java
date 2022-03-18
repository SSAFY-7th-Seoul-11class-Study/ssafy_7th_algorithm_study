package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class 백준_S5_11931_수정렬하기4 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		Integer[] arr= new Integer[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		
		for(Integer a : arr) {
			bw.write(a+"\n");
		}
		br.close();
		bw.close();
	}

}
