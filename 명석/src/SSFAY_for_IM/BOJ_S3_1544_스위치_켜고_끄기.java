package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S3_1544_스위치_켜고_끄기 {
    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            if (Integer.parseInt(st.nextToken()) == 1)
                arr[i] = true;
            else arr[i] = false;
        int op = Integer.parseInt(br.readLine());
        for (int i = 0; i < op; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (sex == 1) man(num);
            else woman(num);
        }
        for (int i = 1; i < N + 1; i++) {

            if (((i - 1) % 20) == 0)
                if (i > 1) bw.newLine();
            if (arr[i] == true) bw.write(1 + " ");
            else bw.write(0 + " ");
        }

        br.close();
        bw.close();
    }

    static void man(int num) {
        for (int i = 0; i < N + 1; i++) {
            if (i % num == 0) arr[i] = !arr[i];
        }

    }

    static void woman(int num) {
        int start = num;
        int end = num;
        int i = 0;
        arr[num] = !arr[num];
        while (true) {
            i++;
            if (num - i < 1 || num + i > N) break;
            start = num - i;
            end = num + i;
            if (arr[start] != arr[end]) break;
            arr[start] = !arr[start];
            arr[end] = !arr[end];

        }
    }
}
