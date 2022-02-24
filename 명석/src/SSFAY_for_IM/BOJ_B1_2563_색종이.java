package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_B1_2563_색종이 {
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[100][100];
        for (int k = 0; k < N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int i = x; i < x + 10; i++)
                for (int j = y; j < y + 10; j++)
                    arr[i][j] = true;

        }
        int count = 0;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (arr[i][j]) count++;

        bw.write(String.valueOf(count));
        br.close();
        bw.close();
    }
}
