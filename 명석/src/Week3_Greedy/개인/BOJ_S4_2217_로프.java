/*
BOJ S4 2217 로프
*/
package Week3_Greedy.개인;

import java.io.*;
import java.util.Arrays;

public class BOJ_S4_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int i = N;
        for (int num : arr) {
            max = max > num * i ? max : num * i;
            i--;
        }
        bw.write(String.valueOf(max));


        br.close();
        bw.close();
    }
}
