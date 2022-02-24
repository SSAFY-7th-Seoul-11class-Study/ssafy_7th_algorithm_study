package 완전탐색;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_S2_1260_DFS와BFS {
	static int [][] check;//간선 연결 상태
	static boolean[] checked; // 확인 여부
	static int n;
	static int m; //간선개수
	static int start;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		start=Integer.parseInt(st.nextToken());
		
		check=new int[1001][1001];
		checked=new boolean[1001];
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			check[x][y]=check[y][x]=1;
		}
		
		dfs(start);
		
		checked=new boolean[1001]; //초기화
		System.out.println();
		
		bfs();
	}
	//시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	  public static void dfs(int i) {
	    checked[i] = true;
	    System.out.print(i + " ");
	    
	    for(int j = 1; j <= n; j++) {
	      if(check[i][j] == 1 && checked[j] == false) {
	        dfs(j);
	      }
	    }
	  }
	  public static void bfs() {
		    Queue<Integer> queue = new LinkedList<Integer>();
		    queue.offer(start); //시작점도 Queue에 넣어야 함
		    checked[start] = true;
		    System.out.print(start + " ");
		    
		    //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
		    while(!queue.isEmpty()) {
		      int temp = queue.poll();
		      
		      for(int j = 1; j <= n; j++) {
		        if(check[temp][j] == 1 && checked[j] == false) {
		          queue.offer(j);
		          checked[j] = true;
		          System.out.print(j + " ");
		        }
		      }
		    }
		  }
}