package SSFAY_for_IM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_S1_2527_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if ((x2 == p1 && y2 == q1) || (x1 == p2 && y2 == q1) || (x2 == p1 && y1 == q2) || (x1 == p2 && y1 == q2)) {
                sb.append("c");
            } else if ((x2 == p1 && y2 != q1) || (x1 == p2 && y2 != q1) || (x2 != p1 && y1 == q2) || (x1 != p2 && y1 == q2)) {
                sb.append("b");
            } else if (x2 < p1 || p2 < x1 || y2 < q1 || q2 < y1) {
                sb.append("d");
            } else {
                sb.append("a");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
