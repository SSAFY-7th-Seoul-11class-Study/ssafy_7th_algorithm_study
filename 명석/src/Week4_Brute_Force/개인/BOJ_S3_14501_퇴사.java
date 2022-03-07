/*
BOJ S3 14501 퇴사
부르트 포스인데 DP도 될 듯?
*/
package Week4_Brute_Force.개인;


import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S3_14501_퇴사 {
    static int N, max = Integer.MIN_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        sum(0, 0);
        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

    static void sum(int n, int result) {
        if (n == N) {
            max = max > result ? max : result;
            return;
        }
        if (n > N) return;
        sum(n + arr[n][0], result + arr[n][1]);
        sum(n + 1, result);
    }
}
