package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{
	int row,col;
	public Location(int row,int col) {
		this.row=row;
		this.col=col;
	}
}

public class 백준_2178_S1_미로탐색  {
	static int N,M;
	static int map[][];
	static int isVisit[][];
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		isVisit=new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j]=str.charAt(j-1)-'0';
			}
		}
		bfs();
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	
	public static void bfs() {
		Queue<Location> queue = new LinkedList<>();
		//큐에 시작점 
		queue.add(new Location(1,1));
		isVisit[1][1]=1; // 방문처리
		
		while(!queue.isEmpty()) {
			Location location = queue.poll();
			int row=location.row;
			int col = location.col;
			
			for(int i=0;i<4;i++) {
				int x= row+dx[i];
				int y= col+dy[i];
				
				if(check(x, y)) {
					queue.add(new Location(x,y));
					isVisit[x][y]=isVisit[row][col]+1; //추가한 노드에 이전까지 간 거리+1;
				}
			}
		}
		
		sb.append(isVisit[N][M]);
		
	}
	public static boolean check(int row,int col) {
		if(row<1 || row>N || col<1 || col>M)
			return false;
		if(isVisit[row][col]!=0 || map[row][col]==0) // 이미 방문한 경우 또는 못가는 경우
			return false;
		
		return true;
	}
}
