package Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		Stack<Integer> stack = new Stack<Integer>();

		int n = Integer.parseInt(br.readLine());

		while (n > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = "";
			command = st.nextToken();

			if (command.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (command.equals("top")) {
				if (stack.empty()) {
					bw.write(-1 + "\n");
					// System.out.println(-1);
				} else {
					bw.write(stack.peek() + "\n");
					// System.out.println(stack.peek());
				}
			} else if (command.equals("size")) {
				// System.out.println(stack.size());
				bw.write(stack.size() + "\n");
			} else if (command.equals("empty")) {
				if (stack.empty()) {
					bw.write(1 + "\n");
					// System.out.println(1);
				} else {
					bw.write(0 + "\n");
					// System.out.println(0);
				}
			} else if (command.equals("pop")) {
				if (stack.empty()) {
					// System.out.println(-1);
					bw.write(-1 + "\n");
				} else {
					// System.out.println(stack.pop());
					bw.write(stack.pop() + "\n");
				}
			}

			n--;
		}
		br.close();

		bw.close();
	}

}
