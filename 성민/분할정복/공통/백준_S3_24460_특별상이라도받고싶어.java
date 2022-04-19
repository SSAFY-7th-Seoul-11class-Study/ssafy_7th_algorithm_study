package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_S3_24460_특별상이라도받고싶어 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N=Integer.parseInt(br.readLine());
		map =new int[N][N];
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(go(N,0,0,N,N));
	}
	
	public static int go(int cnt,int r,int c,int nr,int nc) {
		if(cnt==1) {
			return map[r][c];
		}
		
		int [] nums = new int[4];
		
		cnt/=2;
		
		nums[0]=go(cnt,r,c,nr/2,nc/2);
		nums[1]=go(cnt,r,c+cnt,nr/2,nc);
		nums[2]=go(cnt,r+cnt,c,nr,nc/2);
		nums[3]=go(cnt,cnt+r,cnt+c,nr,nc);
		
		Arrays.sort(nums);
		
		return nums[1];
		
	
	}

}
