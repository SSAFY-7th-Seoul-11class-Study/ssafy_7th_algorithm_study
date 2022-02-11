/*
BOJ S2 1931 회의실 배정
*/
package Week3_Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int arr[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] == o2[1])
                if (o1[0] > o2[0]) return 1;
            return -1;
        });

        int time = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= time) {
                time = arr[i][1];
                count++;
            }
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
