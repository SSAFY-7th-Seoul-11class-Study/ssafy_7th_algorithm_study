package SSFAY_for_IM;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_B1_2605_줄_세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < N; i++) {
            list.add(i - arr[i], i + 1);
        }
        for (int n : list)
            bw.write(n + " ");

        br.close();
        bw.close();
    }
}
