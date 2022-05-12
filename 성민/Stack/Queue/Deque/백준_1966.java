package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_1966 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine()); //테케
		
		while(t>0) {
			st= new StringTokenizer(br.readLine()," ");
			
			int n=Integer.parseInt(st.nextToken());
			int m =Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> dq = new LinkedList<>(); //데큐처럼 사용
			
			st= new StringTokenizer(br.readLine()," ");
			
			for(int i=0;i<n;i++) {
				dq.add(new int [] {i,Integer.parseInt(st.nextToken())}); // 위치와, 우선순위를 함께 저장
			}
			int sol=0;
			
			outer: while(!dq.isEmpty()) {
				int [] pre = dq.peek(); //맨 앞거로 기준
				for(int i=1;i<dq.size();i++) {
					if(pre[1]<dq.get(i)[1]) { //우선 순위 비교
						dq.add(dq.poll()); // 우선순위가 더 큰게 있다면 앞에 거를 뒤로 보냄과 동시에 삭제
						continue outer; // 맨 앞 기준을 바꾸기 위해 continue outer
					}
				}
				int [] out = dq.poll(); // out은 deque에서 제일 앞 요소(우선 순위 제일 큰 것)
				sol++;
				if(out[0]==m) { // 내가 찾는 것과 같다면 마무리(위치 비교)
					bw.write(sol+"\n");
					break;
				}
				//아닐경우 while문 다시 돌면서 계속 sol counting 해준다.
			}
			t--;
		}
		br.close();
		bw.close();
	}
	
}
