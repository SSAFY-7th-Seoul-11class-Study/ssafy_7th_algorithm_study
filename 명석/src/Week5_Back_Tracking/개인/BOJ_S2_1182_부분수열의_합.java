package Week5_Back_Tracking.개인;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S2_1182_부분수열의_합 {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        count = 0;

        subSet(0);
        if (S == 0) count--;
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }

    static void subSet(int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N; i++)
                if (visited[i]) sum += arr[i];
            if (sum == S)
                count++;
            return;
        }
        visited[cnt] = false;
        subSet(cnt + 1);
        visited[cnt] = true;
        subSet(cnt + 1);
    }
}
