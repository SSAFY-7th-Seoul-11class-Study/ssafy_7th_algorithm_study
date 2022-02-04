/*
1874 스택 수열
String으로 결과 값 출력시 메모리 초과 -> StringBuilder로 변경
 */

package Week1.Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 스택에 들어갈 수 
        int length = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        // 결과로 나와야 할 수열
        int[] seq = new int[length];
        for (int i = 0; i < length; i++)
            seq[i] = Integer.parseInt(br.readLine());
        // 스택에 들어갈 수
        int num = 1;
        // 결과 수열 체크
        int count = 0;
        // 수열 생성이 가능한가?
        boolean chk = true;
        // 결과 출력할 문자열
        StringBuilder ans = new StringBuilder();
        while (count < length) {
            // 현재 스택이 비어있다면 입력
            if (stack.empty()) {
                stack.push(num++);
                ans.append("+\n");
            }// 스택이 채워져 있다면
            else {
                // 스택의 top이 현재 수열의 순서와 같다면 pop
                if (stack.peek() == seq[count]) {
                    stack.pop();
                    ans.append("-\n");
                    count++;
                }// 스택의 탑이 현재 수열의 순서보다 작다면 num 입력
                else if (stack.peek() < seq[count]) {
                    stack.push(num++);
                    ans.append("+\n");
                } //스택의 탑이 현재 수열의 순서보다 크다면 불가능!
                else {
                    ans.setLength(0);
                    ans.append("NO");
                    break;
                }
            }
        }
        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}