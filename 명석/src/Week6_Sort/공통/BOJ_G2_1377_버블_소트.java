package Week6_Sort.공통;

import java.io.*;
import java.util.Arrays;

public class BOJ_G2_1377_버블_소트 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            count = count > arr[i][1] - i ? count : arr[i][1] - i;
        }
        bw.write(String.valueOf(count + 1));

        br.close();
        bw.close();
    }
}
