package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG_기능개발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        for(int x : solution(progresses,speeds)) {
        	System.out.print(x+" ");
        }
		
	}
	
	
	    public static int[] solution(int[] progresses, int[] speeds) {
	        int [] answer= {};
            int day;
            int cnt=1;
            Queue<Integer> q = new LinkedList<Integer>();
            ArrayList<Integer> a = new ArrayList<Integer>();
            
            for(int i=0;i<progresses.length;i++){
                day=(int)Math.ceil((100-progresses[i])/speeds[i]);
                q.add(day);
            }
            int temp;
            while(!q.isEmpty()){
                temp=q.poll();  // 맨 앞 기준으로 
                while(!q.isEmpty()){
                    if(temp<q.peek()){
                        break;
                    }else{
                        cnt++;
                        q.poll();
                    }
                }
                a.add(cnt);
                cnt=1;
            }
            answer = new int[a.size()];
            for(int i=0;i<a.size();i++){
                answer[i]=a.get(i);
            }
            
	        return answer;
	    }
	
	

}
