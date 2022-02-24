package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S5_2578_빙고 {
    static int N = 5;
    static int[][] arr = new int[N][N];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        out:
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                delete(n);
                if (check()) {
                    bw.write(String.valueOf(i * 5 + j + 1));
                    break out;

                }
            }
        }

        br.close();
        bw.close();
    }

    static void delete(int n) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                arr[i][j] = arr[i][j] == n ? 0 : arr[i][j];
        }
    }

    static boolean check() {
        count = 0;
        checkR();
        checkC();
        checkRC();
        if (count >= 3) return true;
        return false;
    }

    static void checkR() {
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++)
                if (arr[i][j] == 0) tmp++;
            if (tmp == 5) count++;
        }
    }

    private static void checkC() {
        for (int j = 0; j < N; j++) {
            int tmp = 0;
            for (int i = 0; i < N; i++)
                if (arr[i][j] == 0) tmp++;
            if (tmp == 5) count++;
        }
    }

    private static void checkRC() {
        int tmp = 0;
        for (int i = 0; i < N; i++)
            if (arr[i][i] == 0) tmp++;
        if (tmp == 5) count++;
        tmp = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][N - 1 - i] == 0) tmp++;
        }
        if (tmp == 5) count++;
    }
}
