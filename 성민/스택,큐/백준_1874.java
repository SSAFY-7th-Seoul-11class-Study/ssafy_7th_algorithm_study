package Stack.Queue.Deque;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 백준_1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); // 횟수
		int count =1; // push하는 수들 
		while(n>0) {
			int num = Integer.parseInt(br.readLine());
			
			for(; count<=num;count++) { // count 보다 큰 경우는 push를 해준다. 동시에 count도 증가 시킴
				stack.push(count);
				sb.append("+\n");
			}
			if(stack.peek()==num) { // 스택의 마지막 수가 입력한 수와 같다면 pop을 함과 동시에 - 출력
				stack.pop();
				sb.append("-\n");
			}else {
				
				bw.write("NO"+"\n");
				bw.close();
				return;
			}
			n--;
		}
		bw.write(sb.toString());
		bw.close();
	}

}


