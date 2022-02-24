/*
BOJ S2 4963 섬의 개수
BFS로 풀이
 */
package Week4_Brute_Force.개인;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_4963_섬의_개수 {
    static StringBuilder sb;
    static int w, h;
    static int[][] arr;
    static int count;
    //상 하 좌 우 상좌 하좌 하우 상좌
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++)
                    BFS(i, j);
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    static void BFS(int x, int y) {
        if (arr[x][y] == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = 0;
        count++;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int moveX = cur[0] + dx[i];
                int moveY = cur[1] + dy[i];
                if (moveX >= 0 && moveX <= h - 1 && moveY >= 0 && moveY <= w - 1) {
                    if (arr[moveX][moveY] == 1) {
                        queue.offer(new int[]{moveX, moveY});
                        arr[moveX][moveY] = 0;
                    }
                }
            }


        }
    }
}
