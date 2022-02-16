package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_G5_1068_트리 {

	static int N;
	static int root;
	static int remove;
	static ArrayList<Integer> list[];
	static int[] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		
		
		st=new StringTokenizer(br.readLine()," ");
		
		list=new ArrayList[N];
		answer =new int[N];
		for(int i=0;i<N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			int parent=Integer.parseInt(st.nextToken());
			if(parent==-1) { // root는 부모가 -1이라고 고정
				root =i;
			}else {
				list[parent].add(i);
			}
		}
		
		remove = Integer.parseInt(br.readLine()); // 제거노드
		erase();
		
		sb.append(answer[root]);
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
	static void erase() {
		for(int i=0;i<N;i++) {
			list[i].removeIf(num->num==remove); // Arrays.removeIf 함수(조건에 해당되는 노드만 삭제)
		}
		if(remove!=root) { //루트자체를 지우면 DFS 할 필요가없으니
			DFS(root,-1);
		}
		
		
	}
	static void DFS(int x,int parent) { //위치한 노드, 부모노드
		if(list[x].isEmpty()) { //자식이 없는 경우 =>리프노드
			answer[x]=1; 
		}
		
		for(int y:list[x]) {
			DFS(y,x);
			answer[x]+=answer[y]; //위에 if문으로 1이 생기므로 부모로 누적시킨다.
		}
	}
	

}
