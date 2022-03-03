package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S4_10158_개미 {
    static int N, M;
    static int x, y;
    static int time;
    static int dir = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());
        br.close();
        bw.close();
    }

}
