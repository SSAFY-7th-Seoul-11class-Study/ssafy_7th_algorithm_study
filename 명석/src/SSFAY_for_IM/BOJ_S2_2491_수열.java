package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S2_2491_수열 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int length = 1;
        int max = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] >= arr[i]) length++;
            else length = 1;
            max = max > length ? max : length;
        }
        length = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] <= arr[i]) length++;
            else length = 1;
            max = max > length ? max : length;
        }
        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
