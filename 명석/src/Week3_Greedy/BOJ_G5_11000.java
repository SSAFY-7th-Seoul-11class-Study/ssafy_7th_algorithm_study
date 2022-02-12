/*
BOJ G5 11000 강으실 배정
- 회의실 배정과의 차이 : 회으실은 전체 가능한 갯수를 뽑아 내는 것, 강의실은 뽑아내고 남은 것들로 계속해서 뽑아 최소의 강의실 필요수를 뽑아내기
1. 처음에 풀이 : visited 배열 사용해서 전체 다 뽑아질때까지 반복
2. 위보다 좀 낫게 큐로 돌려봄. 지금 사용가능한 강의실이면 poll 아니면 다시 offer 끝까지 돌면 반복
3. 계속해서 시간 초과(사실상 부르트 포스)
4. 이제난 어떻게 해야할까
5, 결국 구글 참고
https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Java
*/
package Week3_Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2. 큐로 풀이
public class BOJ_G5_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 시작시간 오름차순, 종료시간 오름차순으로 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return -1;
        });
        // 각 강의실이 들어갈 우선순위큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]); // 맨첫번째 강의실 입력
        for (int i = 1; i < N; i++) {
            // 현재 강의의 시작시간과 현 강의실들 중 가장 빠른 종료시간을 가진 강의시간에 붙이기
            // 있으면 알아서 poll + offer로 갱신 되지만,
            // 없다는 것은 현재 강의실들이 중복된다는 뜻이므로 새로운 강의실 배정
            if (pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.add(arr[i][1]);
        }
        bw.write(String.valueOf(pq.size()));
        br.close();
        bw.close();
    }
}

// 3. 브루트 포스 -> 시간 초과
//public class BOJ_G5_11000 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        int[][] arr = new int[N][2];
//        int result = 0;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr, (o1, o2) -> {
//            if (o1[1] > o2[1]) return 1;
//            else if (o1[1] == o2[1])
//                if (o1[0] > o2[0]) return 1;
//            return -1;
//        });
//        Queue<int[]> queue = new LinkedList<>();
//        for (int i = 0; i < N; i++) {
//            queue.add(arr[i]);
//        }
//        while (!queue.isEmpty()) {
//            int time = 0;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                if (queue.peek()[0] >= time) {
//                    time = queue.poll()[1];
//                } else queue.offer(queue.poll());
//            }
//            result++;
//        }
//
//        bw.write(String.valueOf(result));
//        br.close();
//        bw.close();
//    }
//}

