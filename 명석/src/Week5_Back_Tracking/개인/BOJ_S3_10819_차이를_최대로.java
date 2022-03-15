package Week5_Back_Tracking.개인;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S3_10819_차이를_최대로 {
    static int N;
    static int[] arr;
    static int[] choosed;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        choosed = new int[N];
        visited = new boolean[N];
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        perm(0);
        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }

    static void perm(int count) {
        if (count == N) {
            int result = 0;
            for (int i = 0; i < N-1; i++)
                result += Math.abs(choosed[i] - choosed[i + 1]);
            max = max > result ? max : result;

        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[count] = arr[i];
                perm(count + 1);
                visited[i] = false;
            }
        }
    }
}
