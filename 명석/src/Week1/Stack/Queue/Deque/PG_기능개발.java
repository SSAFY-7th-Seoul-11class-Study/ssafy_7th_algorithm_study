/*
프로그래머스 기능개발
 */

package Week1.Stack.Queue.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class PG_기능개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        for(int x : solution(progresses, speeds))
            System.out.print(x + " ");
        br.close();
        bw.close();
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        Stack<Integer> progress = new Stack<Integer>();
        Stack<Integer> speed = new Stack<Integer>();
        // 답을 저장할 변수
        int count = 0;
        // 스택에 진행도 입력
        for (int i = progresses.length - 1; i >= 0; i--) {
            progress.push(progresses[i]);
            speed.push(speeds[i]);
        }
        // 스택
        while (!progress.empty()) {
            int currentSize = progress.size();
            int finish = 0;
            for (int i = currentSize - 1; i >= 0; i--) {
                progress.set(i, progress.get(i) + speed.get(i));
            }
            while (!progress.empty() && progress.peek() >= 100) {
                progress.pop();
                speed.pop();
                finish++;
            }
            if (currentSize != progress.size()) temp[count++] = finish;
        }
        int[] answer = Arrays.copyOf(temp,count);
        return answer;
    }

}
