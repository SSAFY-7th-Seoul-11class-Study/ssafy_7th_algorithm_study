/*
BOJ S3 11399 ATM
*/
package Week3_Greedy.공통;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int sum = arr[0];
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
            sum += arr[i];
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}
