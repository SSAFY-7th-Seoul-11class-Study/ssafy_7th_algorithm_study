/*
BOJ S2 11047 동전 0
*/
package Week3_Greedy.공통;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S3_11047_동전_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int countCoin = 0;
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                int count = K / coins[i];
                countCoin += count;
                K = K % coins[i];
            }
        }
        bw.write(String.valueOf(countCoin));
        br.close();
        bw.close();
    }
}
