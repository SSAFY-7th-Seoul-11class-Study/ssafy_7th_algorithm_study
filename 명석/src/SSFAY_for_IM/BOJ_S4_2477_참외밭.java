package SSFAY_for_IM;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S4_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (dir >= 3) {
//                maxR=maxR<distance?distance:maxR; if (maxR==distance) indexR=i;



            }
            arr[i] = length;
        }

        br.close();
        bw.close();
    }
}
