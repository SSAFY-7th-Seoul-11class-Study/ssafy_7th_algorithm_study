package Week5_Back_Tracking.개인;

import java.io.*;

public class BOJ_S3_10974_모든_순열 {
    static int N;
    static int[] arr;
    static int[] choosed;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        choosed = new int[N];
        visited = new boolean[N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            arr[i] = i + 1;
        perm(0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    static void perm(int count) {
        if (count == N) {
            int result = 0;
            for (int i = 0; i < N; i++)
                sb.append(choosed[i]).append(" ");
            sb.append("\n");
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
