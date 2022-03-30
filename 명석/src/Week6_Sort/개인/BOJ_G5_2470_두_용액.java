package Week6_Sort.개인;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2470_두_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;
        int chk1 = start;
        int chk2 = end;
        while (start < end) {
            if (Math.abs(arr[start] + arr[end]) < min) {
                min = Math.abs(arr[start] + arr[end]);
                chk1 = start;
                chk2 = end;
            }
            if (arr[start] + arr[end] < 0)
                start++;
            else end--;
        }
        bw.write(arr[chk1] + " " + arr[chk2]);

        br.close();
        bw.close();
    }
}
