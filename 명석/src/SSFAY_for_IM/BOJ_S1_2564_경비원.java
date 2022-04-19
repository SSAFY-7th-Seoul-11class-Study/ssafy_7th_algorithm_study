package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {
    static int N, M, line;
    static int x, y;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        line = N * 2 + M * 2;
        int tc = Integer.parseInt(br.readLine());
        arr = new int[tc][2];
        int sum = 0;
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            arr[t][0] = Integer.parseInt(st.nextToken());
            arr[t][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++)
            sum += calc(arr[i][0], arr[i][1]);

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }

    static int calc(int r, int c) {
        int X;
        if (x == 1) X = y;
        else if (x == 4) X = N + y;
        else if (x == 2) X = N + M + N - y;
        else X = M + N + N + M - y;

        int point;
        if (r == 1) point = c;
        else if (r == 4) point = N + c;
        else if (r == 2) point = N + M + N - c;
        else point = M + N + N + M - c;

        int distance;
        if (X > point)
            distance = X - point < line - X + point ? X - point : line - X + point;
        else
            distance = point - X < line - point + X ? point - X : line - point + X;

        return distance;
    }
}
