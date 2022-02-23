/*
BOJ S1 2583 영역 구하기
- 그림과 거의 비슷
- BFS로 풀이
- 8퍼센트에서 계속 틀려서 왜? -> 입력을 3번만 받음 -> 진짜 미친넘
 */
package Week4_Brute_Force.개인;

import java.io.*;
import java.util.*;

public class BOJ_S1_2583_영역_구하기 {
    static int N, M;
    static int[][] arr;
    static int count;
    static ArrayList<Integer> areas;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        count = 0;
        areas = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            for (int i = startX; i < endX; i++)
                for (int j = startY; j < endY; j++)
                    arr[i][j] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                BFS(i, j);
            }
        }
        Collections.sort(areas);
        StringBuilder sb = new StringBuilder().append(count).append("\n");
        for (int area : areas)
            sb.append(area).append(" ");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void BFS(int x, int y) {
        if (arr[x][y] != 0) return;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = 1;
        count++;
        int area = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            area++;
            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + dx[i];
                int moveY = cur[1] + dy[i];
                if (moveX >= 0 && moveX <= N - 1 && moveY >= 0 && moveY <= M - 1) {
                    if (arr[moveX][moveY] == 0) {
                        queue.offer(new int[]{moveX, moveY});
                        arr[moveX][moveY] = 1;
                    }
                }
            }
        }
        areas.add(area);
    }
}
