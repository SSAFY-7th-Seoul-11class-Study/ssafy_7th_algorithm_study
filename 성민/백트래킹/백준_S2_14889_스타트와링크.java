package 백트래킹;
/**
 * 조합을 이용해서 풀면댔다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S2_14889_스타트와링크 {
	static int N;
	static int map[][];
	static int answer=Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		visited= new boolean[N];
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}// 맵
		
		comb(0,0);
		bw.write(answer+"\n");
		br.close();
		bw.close();
		
	}
	public static void comb(int cnt,int start) {
		if(cnt==N/2) {
			diff();
			return;
		}
		
		
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(cnt+1,i+1);
				visited[i]=false;
			}
		}
	}
	
	public static void diff() {
		int start_team=0;
		int link_team=0;
		
		for(int r=0;r<N-1;r++) {
			for(int c=r+1;c<N;c++) {
				if(visited[r]== true && visited[c]==true) {
					start_team+=map[r][c];
					start_team+=map[c][r];
				}
				
				else if(visited[r]==false && visited[c]==false) {
					link_team+=map[r][c];
					link_team+=map[c][r];
				}
			}
		}
		
		int num =Math.abs(start_team-link_team);
		
		if(answer==0) { // 이게 제일 최소니까 더 할필요 없음
			System.out.println(answer);
			System.exit(0);
		}
		
		answer = Math.min(answer, num);
	}

}
