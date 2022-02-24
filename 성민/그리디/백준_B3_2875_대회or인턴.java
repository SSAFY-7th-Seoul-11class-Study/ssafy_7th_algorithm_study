package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_B3_2875_대회or인턴 {

	static int N, M, K;
	static int cnt;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		while(N>=2 && M!=0) {
			N-=2;
			M-=1;
			
			if(N+M <K) {
				break;
			}
			cnt++;
		}
		
		bw.write(cnt + "");
		br.close();
		bw.close();
	}
}
