package Week6_Sort.개인;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_11004_K번째_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        bw.write(String.valueOf(arr[K]));
        br.close();
        bw.close();
    }
}
