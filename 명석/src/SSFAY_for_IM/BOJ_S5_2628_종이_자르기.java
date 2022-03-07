package SSFAY_for_IM;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S5_2628_종이_자르기 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> listR = new ArrayList<>();
        listR.add(N);
        ArrayList<Integer> listC = new ArrayList<>();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.close();
    }
}
