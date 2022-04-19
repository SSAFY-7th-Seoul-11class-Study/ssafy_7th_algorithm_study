package Week5_Back_Tracking.공통;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S2_14889_스타트와_링크 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0);
        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    static void comb(int count, int idx) {
        if (count == N / 2) {
            calc();
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calc() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j])
                    start += (arr[i][j] + arr[j][i]);
                else if (!visited[i] && !visited[j])
                    link += (arr[i][j] + arr[j][i]);
            }
        }
        int different = Math.abs(start - link);
        min = min < different ? min : different;

    }
}
