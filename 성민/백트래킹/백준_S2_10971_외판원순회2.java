package 백트래킹;
/**
 *  출발지점을 모든 도시를 출발지로한다.
 *  
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_S2_10971_외판원순회2 {
	static int N;
	static int map[][];
	static boolean[] visited; //방문한 도시 처리
	static int answer =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken()); //r->c로 가는 
			}
		}//맵
		
		for(int i=0;i<N;i++) { //시작위치 몰라서 다함
			visited=new boolean[N]; 
			visited[i]=true;
			dfs(i,i,0);
		}
		bw.write(answer+"\n");
		br.close();
		bw.close();
	}
	public static boolean allvisited() {
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int start, int now ,int cost) {
		if(allvisited()) {
			if(map[now][start]!=0) { // 모두 방문을 했고 마지막 위치에서 처음으로 가는 길 존재한다면 
				answer=Math.min(answer, cost+map[now][0]); //기존까지 다 돌았던 값이랑 cost+에서 마지막 위치에서 돌아오는 값이랑 합친 것 중 최소를 선택
			}
			return;
		}
		
		for(int i=1;i<N;i++) {
			if(!visited[i] && map[now][i]!=0) { //방문 안했고 길 존재하는 경우
				visited[i]=true;
				dfs(start,i,cost+map[now][i]);
				visited[i]=false;
			}
		}
	}

}
