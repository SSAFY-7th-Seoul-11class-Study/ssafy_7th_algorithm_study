package Week4_Brute_Force.공통;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697_숨바꼭질 {
    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        BFS(N, 0);
        if (visited[K] == -1) // N, K가 같을 때
            bw.write(String.valueOf(0));
        else bw.write(String.valueOf(visited[K]));

        br.close();
        bw.close();
    }

    static void BFS(int N, int startCount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, startCount});
        visited[N] = -1;// N과 K가 같을 경우를 대비

        while (!queue.isEmpty()) {
            int[] check = queue.poll();
            int curN = check[0];
            int count = check[1];

            if (curN == K) {
                break;
            } else {
                for (int i = 0; i < 3; i++) {
                    int num;
                    if (i == 0) {
                        num = curN + 1;
                    } else if (i == 1) {
                        num = curN - 1;
                    } else num = curN * 2;
                    if (num >= 0 && num <= 100000) {
                        if (visited[num] == 0) {
                            // 다음으로 진행할 위치가 범위 내이고, 방문을 아직 안했다면,
                            // 방문을 한 경우 현재보다 무조건 빠르기 때문.
                            queue.add(new int[]{num, count + 1});
                            visited[num] = count + 1;
                        }
                    }
                }
            }
        }
    }

}
