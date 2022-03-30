package Week6_Sort.공통;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S4_10816_숫자_카드_2 {
    static int N;
    static int M;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int chk = Integer.parseInt(st.nextToken());
            if (map.containsKey(chk))
                bw.write(map.get(chk) + " ");
            else bw.write(0 + " ");
        }

        br.close();
        bw.close();
    }
}
