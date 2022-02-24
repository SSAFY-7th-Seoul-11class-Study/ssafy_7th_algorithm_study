package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_S4_2503_숫자야구 {
	static int N;
	static List<Baseballdata> inputData = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");

			int data=Integer.parseInt(st.nextToken());
			int strike=Integer.parseInt(st.nextToken());
			int ball=Integer.parseInt(st.nextToken());
			
			Baseballdata baseballdata = new Baseballdata(data, strike, ball);
			inputData.add(baseballdata);
		}
		bw.write(calBaseBall()+"\n");
		br.close();
		bw.close();
	}
	
	static int calBaseBall() {
		int result=0;
		
		for(int i=123;i<=987;i++) {
			if(!checked(i)) continue; //중복숫자
			
			int testcnt=0;
			
			for(int j=0;j<N;j++) {
				int strikeCount=0;
				int ballCount=0;
				
				Baseballdata current = inputData.get(j); //맞추려고 제시한 숫자
				String currentDataString = Integer.toString(current.data);
				String myDataString = Integer.toString(i); // 모든 경우의수
				
				for(int k=0;k<3;k++) {
					if (currentDataString.charAt(k)==myDataString.charAt(k)) {
						strikeCount++;
					}
				}
				
				for(int k=0;k<3;k++) {
					for(int h=0;h<3;h++) {
						if(myDataString.charAt(k)==currentDataString.charAt(h)) {
							if(k!=h)
								ballCount++;
						}
					}
				}
				if(current.strike==strikeCount && current.ball==ballCount) {
					testcnt++;
				}
				
			}
			if(testcnt==N) {
				result++;
			}
		}
		return result;
	}

	static boolean checked(int num) {
		String numStr= Integer.toString(num);
		
		if(numStr.charAt(0)==numStr.charAt(1)) {
			return false;
		}
		if(numStr.charAt(1)==numStr.charAt(2)) {
			return false;
		}
		if(numStr.charAt(0)==numStr.charAt(2)) {
			return false;
		}
		if(numStr.charAt(0)=='0' ||numStr.charAt(1)=='0'||numStr.charAt(2)=='0') {
			return false;
		}
		
		return true;
	}
	
	static class Baseballdata {
		int data;
		int strike;
		int ball;
		
		
		public Baseballdata(int data,int strike,int ball) {
			this.data=data;
			this.strike=strike;
			this.ball=ball;
		}
	}
}
