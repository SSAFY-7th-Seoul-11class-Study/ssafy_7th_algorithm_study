package greedy;


/** 
 *  단순 무식하게 Queue로 했다가 메모리 초과 나고 난리남
 *  좀 생각해보니 어차피 순서를 정렬해야 하는데 우선순위 큐 쓰면 되겠다 싶음.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 백준_G4_1715_카드정렬하기 {
	static int N;
	static int sum=0;
	static int temp=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

		N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int sum=0;
		while(pq.size()>1) {
			int num1 =pq.poll();
			int num2=pq.poll();
			
			sum+=num1+num2;
			pq.add(num1+num2);
			
		}
		
		bw.write(sum+"\n");
		br.close();
		bw.close();
	}
	
}
