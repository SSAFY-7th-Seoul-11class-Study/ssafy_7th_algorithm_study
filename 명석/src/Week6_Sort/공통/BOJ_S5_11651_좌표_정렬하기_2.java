package Week6_Sort.공통;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_11651_좌표_정렬하기_2 {
    static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static point[] pts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        pts = new point[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pts[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(pts, (o1, o2) -> {
            if (o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            else
                return Integer.compare(o1.y, o2.y);
        });

        for (point p : pts)
            bw.write(p.x + " " + p.y + "\n");
        br.close();
        bw.close();
    }
}
