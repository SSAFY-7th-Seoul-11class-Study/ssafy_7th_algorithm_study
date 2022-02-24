/**
 * 아무 생각없이 answer =0을 주고 했다가 0부터 시작하는 반례가 생김 
 * 그래서 그냥 MAX_VALUE를 주고 시작
 */


package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S2_1541번_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer minus = new StringTokenizer(br.readLine(),"-");
		int answer=Integer.MAX_VALUE;
		while(minus.hasMoreTokens()) {
			int temp=0;
			StringTokenizer plus = new StringTokenizer(minus.nextToken(),"+");
			
			while(plus.hasMoreTokens()) {
				temp+=Integer.parseInt(plus.nextToken());
			}
			
			if(answer==Integer.MAX_VALUE) { //answer ==0 인 경우 0-10-20+30 이런 식에서 반례발생
				answer=temp;
			}else {
				answer-=temp;
			}
			
		}
		bw.write(answer+"\n");
		
		br.close();
		bw.close();
	}

}
