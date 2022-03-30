package Week6_Sort.공통;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_S5_11931_수_정렬하기_4 {
    static int N;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int n : arr)
            bw.write(n + "\n");

        br.close();
        bw.close();
    }
}
