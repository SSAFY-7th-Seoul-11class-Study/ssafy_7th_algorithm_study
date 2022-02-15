/*
17413 단어 뒤집기

 */
package Week1_Stack_Queue_Deque.개인;

import java.io.*;
import java.util.Stack;

public class BOJ_S3_17413_단어_뒤집기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        boolean chkEs = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!chkEs && (ch == '<')) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                chkEs = true;
                sb.append(ch);
            } else if (chkEs && (ch == '>')) {
                chkEs = false;
                sb.append(ch);

            } else {
                if (chkEs) {
                    sb.append(ch);
                } else {
                    if (ch == ' ') {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(ch);

                    } else {
                        stack.push(ch);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
