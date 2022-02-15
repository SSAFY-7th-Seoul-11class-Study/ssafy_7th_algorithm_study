package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class 백준_S2_1931_회의실배정 {
	static int N;
	static int room[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		room=new int [N][2];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			room[i][0]=Integer.parseInt(st.nextToken()); // 시작시간
			room[i][1]=Integer.parseInt(st.nextToken()); //종료 시간
		}
		
		Arrays.sort(room,new Comparator<int []>() { //시작 시간 오름차순
			public int compare(int[] r1,int[] r2) {
				return r1[0]-r2[0];
			}
		});
		
		Arrays.sort(room,new Comparator<int []>() { //끝나는 시간 오름차순
			public int compare(int[] r1,int[] r2) {
				return r1[1]-r2[1];
			}
		});
		
		
		
		
		int cnt=0;
		int end_time=0;
		
		for(int i=0;i<N;i++) {
			if(room[i][0]>=end_time) { //시작시간이 end_time 보다 크거나 같으면 end_time 해당하는 회의가 끝나는 시간으로 둔다
				end_time=room[i][1];
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		br.close();
		bw.close();
	}

}
