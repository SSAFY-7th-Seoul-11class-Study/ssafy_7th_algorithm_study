package Week6_Sort.개인;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S5_11728_배열_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            b[i] = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + M];
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i + j < N + M) {
            if (a[i] < b[j]) {
                sb.append(a[i]).append(" ");
                i++;
                if (i == N) {
                    for (int k = j; k < M; k++)
                        sb.append(b[k]).append(" ");
                    break;
                }
            } else {
                sb.append(b[j]).append(" ");
                j++;
                if (j == M) {
                    for (int k = i; k < N; k++)
                        sb.append(a[k]).append(" ");
                    break;
                }
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
