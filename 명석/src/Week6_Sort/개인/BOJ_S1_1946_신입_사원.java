package Week6_Sort.개인;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_1946_신입_사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (o1, o2) -> {
                return Integer.compare(o1[0], o2[0]);
            });
            int count = 1;
            int min = arr[0][1];
            for (int i = 1; i < N; i++) {
                if (arr[i][1] < min) {
                    min = arr[i][1];
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
