/*
BOJ B3 2875 대회 or 인턴
*/
package Week3_Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_B3_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = Math.min(N / 2, M);

        while (true) {
            if ((N - count * 2) + (M - count) >= K)
                break;
            else count--;
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
