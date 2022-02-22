/*
BOJ S1 21778 미로탐색
*/
package Week4_Brute_Force.공통;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2178_미로탐색 {
    static int[][] arr;
    static int[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 0)
                    visited[i][j] = -1;
            }
        }

        BFS(new int[]{0, 0});
        bw.write(String.valueOf(visited[N - 1][M - 1]));

        br.close();
        bw.close();
    }

    static void BFS(int xy[]) {
        Queue<int[]> queue = new LinkedList<>();
        visited[xy[0]][xy[1]] = 1;
        queue.add(xy);
        // 상
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 상
            if (x > 0 && arr[x - 1][y] == 1)
                if (visited[x - 1][y] == 0) {
                    queue.add(new int[]{x - 1, y});
                    visited[x - 1][y] = visited[x][y] + 1;
                }
            // 하
            if (x < N - 1 && arr[x + 1][y] == 1)
                if (visited[x + 1][y] == 0) {
                    queue.add(new int[]{x + 1, y});
                    visited[x + 1][y] = visited[x][y] + 1;
                }
            // 좌
            if (y > 0 && arr[x][y - 1] == 1)
                if (visited[x][y - 1] == 0) {
                    queue.add(new int[]{x, y - 1});
                    visited[x][y - 1] = visited[x][y] + 1;
                }
            // 우
            if (y < M - 1 && arr[x][y + 1] == 1)
                if (visited[x][y + 1] == 0) {
                    queue.add(new int[]{x, y + 1});
                    visited[x][y + 1] = visited[x][y] + 1;
                }
        }
    }

}
