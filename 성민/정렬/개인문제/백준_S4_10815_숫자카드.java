package 정렬.개인문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S4_10815_숫자카드 {
	static int N,M;
	static int[] ishave;
	
	static int[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		
		N=Integer.parseInt(br.readLine());
		ishave =new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			ishave[i]=Integer.parseInt(st.nextToken());
		}
		M=Integer.parseInt(br.readLine());
		Arrays.sort(ishave); // 이분탐색을 하려면 배열정렬부터해야됨
		st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<M;i++) {
			int ans=BinarySearch(Integer.parseInt(st.nextToken()));
			if(ans!=-1) {
				bw.write(1+" ");
			}else {
				bw.write(0+" ");
			 }
		}

		br.close();
		bw.close();
		
		
	}
	
	public static int BinarySearch(int target) {
		int left=0;
		int right=ishave.length-1;
		int mid;
		
		while(left<=right) {
			mid=(left+right)/2;
			if(ishave[mid]<target) {
				left=mid+1;
			}else if(ishave[mid]>target) {
				right=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}
