/*
1966 프린터 큐
처음엔 큐나 우선순위큐로 풀려고 했으나, 인덱스 조회불가로
링크드 리스트 디큐로 풀이
 */
package Week1_Stack_Queue_Deque.공통;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Printer {
    int seq;
    int priority;

    public Printer(int seq, int priority) {
        this.seq = seq;
        this.priority = priority;
    }
}

public class BOJ_S3_1966_프린터_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            // 큐의 크기
            int size = Integer.parseInt(st.nextToken());
            // 원하는 순서
            int wantSeq = Integer.parseInt(st.nextToken());
            Deque<Printer> pq = new LinkedList<>();

            // 큐 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                pq.addLast(new Printer(i, Integer.parseInt(st.nextToken())));
            }

            int result = checkCount(pq, wantSeq);
            bw.write(String.valueOf(result));
            bw.newLine();
        }


        br.close();
        bw.close();
    }

    static int checkCount(Deque<Printer> pq, int wantSeq) {
        // wantSeq가 몇번째 순서인지 체크
        int count = 0;

        // 큐가 비워질때까지 반복
        while (pq.size() > 0) {
            // 디큐의 입력 방향에서 뽑기
            Printer temp = pq.pollFirst();
            // 현재 뽑은 원소보다 중요도가 높은 원소가 있는지 확인
            boolean chkIn = false;
            for (Printer p : pq) {
                if (p.priority > temp.priority) {
                    chkIn = true;
                    break;
                }
            }
            // 중요도 높은게 있다면 맨 뒤로 입력
            if (chkIn) pq.addLast(temp);
                // 없다면 그대로 poll, 만약 현재 뽑은 것이 맞다면 반복 종료
            else {
                count++;
                if (temp.seq == wantSeq) break;
            }
        }
        return count;
    }
}
