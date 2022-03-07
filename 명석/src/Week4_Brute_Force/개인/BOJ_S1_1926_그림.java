/*
BOJ S1 1926 그림
BFS로 풀이
 */
package Week4_Brute_Force.개인;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1926_그림 {
    static int N, M;
    static int[][] arr;
    static int count;
    static int max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        count = 0;
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                BFS(i, j);
            }
        }
        bw.write(new StringBuilder().append(count).append("\n").append(max).toString());

        br.close();
        bw.close();
    }

    static void BFS(int x, int y) {
        if (arr[x][y] != 1) return;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = 0;
        count++;
        int art = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            art++;
            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + dx[i];
                int moveY = cur[1] + dy[i];
                if (moveX >= 0 && moveX <= N - 1 && moveY >= 0 && moveY <= M - 1) {
                    if (arr[moveX][moveY] == 1) {
                        queue.offer(new int[]{moveX, moveY});
                        arr[moveX][moveY] = 0;
                    }
                }
            }
        }
        max = max > art ? max : art;
    }
}
