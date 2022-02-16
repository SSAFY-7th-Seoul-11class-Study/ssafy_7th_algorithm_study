/*
2493 탑
1. 배열로 입력을 받으면서 입력 받은 곳에서 왼쪽으로 바로 순회하여 입력값보다 큰 값을 결과 배열에 저장 -> 시간 초과
2. 스택을 이용
 -> 현재 입력받은 탑의 높이보다 원래 입력받아져 있는 탑들의 높이가 작다면 그 이후의 탑들은 닿을 수 없음.
 -> 현재 입력받은 탑의 높이가 가장 큰 높이라면 당연히 그 이후의 탑들이 현재 입력받은 탑만이 수신할 수 있게 됨.
 -> 그러므로 현재 입력받은 탑에서 그전의 탑들을 비교하여 더 높은 탑을 만날때까지 pop해주면 됨.
*/
package Week1_Stack_Queue_Deque.개인;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int seq;
    int height;

    public Top(int seq, int height) {
        this.seq = seq;
        this.height = height;
    }
}

public class BOJ_G5_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 송신탑 갯수
        int N = Integer.parseInt(br.readLine());
        // 각 탑별 송신 결과
        StringBuilder sb = new StringBuilder();
        // 탑 배열 입력과 동시에 수신 탑 결과 계산
        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 입력할 탑
            Top current = new Top(i + 1, Integer.parseInt(st.nextToken()));
            // 스택이 비어 있지 않다면
            while (stack.isEmpty() == false) {
                // 현재의 탑보다 그전의 입력받은 탑이 크다면 출력값에 넣기
                if (stack.peek().height >= current.height) {
                    sb.append(stack.peek().seq + " ");
                    break;
                }
                // 작은 탑들은 제거 (송신받을 탑과 현재 탑의 사이에 있는)
                else stack.pop();
            }
            // 스택에 아무것도 없다면 송신 불가
            if (stack.size() == 0)
                sb.append(0 + " ");
            stack.push(current);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}