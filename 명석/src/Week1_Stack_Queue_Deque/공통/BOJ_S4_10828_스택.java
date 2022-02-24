/*
10828 스택
*/

package Week1_Stack_Queue_Deque.공통;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S4_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));
            else if (str.equals("pop"))
                if (stack.empty())
                    bw.write(-1 + "\n");
                else bw.write(stack.pop() + "\n");
            else if (str.equals("size"))
                bw.write(stack.size() + "\n");
            else if (str.equals("empty"))
                if (stack.empty())
                    bw.write(1 + "\n");
                else bw.write(0 + "\n");
            else if (str.equals("top"))
                if (stack.empty())
                    bw.write(-1 + "\n");
                else
                    bw.write(stack.peek() + "\n");
        }

        br.close();
        bw.close();
    }
}
