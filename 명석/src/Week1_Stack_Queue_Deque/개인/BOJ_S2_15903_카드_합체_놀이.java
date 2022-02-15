/*
15903 카드 합체
처음엔 값을 int로 설정 _ 오버플로우 발생 => long으로 설정
우선순위 큐를 통해 풀긴 했지만 그리디 알고리즘에 가까운 듯?
매 순간 합체할때마다 가장 작은 수 2가지를 더하고 최종적으로 싹 다 더하면 답.
배열의 정렬을 해서도 가능할듯
 */

package Week1_Stack_Queue_Deque.개인;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S2_15903_카드_합체_놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++)
            pq.offer(Long.parseLong(st.nextToken()));
        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;

            pq.offer(sum);
            pq.offer(sum);
        }
        long result = 0;
        for (int i = 0; i < N; i++)
            result += pq.poll();
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
