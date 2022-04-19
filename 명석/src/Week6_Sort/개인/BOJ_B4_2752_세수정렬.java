package Week6_Sort.개인;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B4_2752_세수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for (int n : arr)
            bw.write(n + " ");

        br.close();
        bw.close();
    }
}
