package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class 백준_S5_1427_소트인사이드 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = br.readLine();
		Integer arr[] = new Integer[num.length()];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=num.charAt(i)-'0';
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int a : arr) {
			sb.append(a);
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
