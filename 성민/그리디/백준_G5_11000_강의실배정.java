package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_G5_11000_강의실배정 {
	static int N;//수업 개수
	static int[][] time; // 수업시간
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		time=new int[N][2]; //시작시간 ,종료시간 이렇게 2개
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			time[i][0]=Integer.parseInt(st.nextToken()); //시작시간
			time[i][1]=Integer.parseInt(st.nextToken());//종료시간
		}
		
		Arrays.sort(time,new Comparator<int []>() { //시작 시간 오름차순
			public int compare(int[] r1,int[] r2) {
				if(r1[0]==r2[0]) {
					return r1[1]-r2[1];
				}
				return r1[0]-r2[0];
			}
		});
		
//		Arrays.sort(time,new Comparator<int []>() { //끝나는 시간 오름차순
//			public int compare(int[] r1,int[] r2) {
//				return r1[1]-r2[1];
//			}
//		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(time[0][1]); //정렬 시킨거 첫 종료값을 넣고
		
		for(int i=1;i<N;i++) { //두번째 꺼부터 탐색
			if(pq.peek()<=time[i][0]) { //시작시간이 뒤라면 사용한 강의실 그대로 쓸 수 있으니 빼고 시작시간이 끝나는 시간 이전이라면 강의실 사용중이라고 큐 냅두고
				pq.poll();
			}
			pq.add(time[i][1]); //빼고 다시 넣을수도 있고 // 새로운 강의실 추가 할 수도 
		}
		bw.write(pq.size()+"\n");
		br.close();
		bw.close();
	}

}
