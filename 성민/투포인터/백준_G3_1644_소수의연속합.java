package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Me1st
 * 에라토스테네스체만 구현 할 줄 알면 나머지는 기존 투포인터랑 차이없음
 */

public class 백준_G3_1644_소수의연속합 {
	static int N;
	static boolean isPrime[];
	static List<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		list =new ArrayList<>();
		
		isPrime=new boolean[N+1];
		isPrime[0]=isPrime[1]=true; //0과 1 소수 아니니까
		
		for(int i=2;i*i<=N;i++) {
			if(!isPrime[i]) {
				for(int j=i*i;j<=N;j+=i) {
					isPrime[j]=true;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!isPrime[i]) {
				list.add(i);
			}
		} // 소수 구하기
		list.add(0); //이거 해줘야 마지막 인덱스 탐색이됨 ㅠㅠ
		int sum=0;
		int left=0,right=0,cnt=0;
		
		while(left<=right && right<list.size()) {
			if(sum<N) {
				sum+=list.get(right++);
			}else {
				if(sum==N) {
					cnt++;
				}
				sum-=list.get(left++);
			}
		}
		
		bw.write(cnt+"\n");
		br.close();
		bw.close();
		
	}		
}
