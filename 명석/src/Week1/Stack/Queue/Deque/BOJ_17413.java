/*
17413 단어 뒤집기

 */
package Week1.Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17413 {
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
