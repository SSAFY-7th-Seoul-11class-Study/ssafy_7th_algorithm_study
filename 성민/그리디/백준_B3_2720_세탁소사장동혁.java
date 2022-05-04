package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_B3_2720_세탁소사장동혁 {
	static int T,C;
	static int coin[] = {25,10,5,1};
	static int answer[];
	static int Q,D,N,P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			answer = new int[4];
			C=Integer.parseInt(br.readLine());
			for(int i=0;i<4;i++) {
				answer[i]=C/coin[i];
				C%=coin[i];
				
				bw.write(answer[i]+" ");
			}
			bw.write("\n");
			
			
		}
		br.close();
		bw.close();
		
	}

}
