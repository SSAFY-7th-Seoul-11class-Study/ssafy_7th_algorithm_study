package Week5_Back_Tracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S1_14888_연산자_끼워넣기 {
    static int N;
    static int[] arr;
    static int[] op;
    static boolean[] visited;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        op = new int[N - 1];
        visited = new boolean[N - 1];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int opCode = Integer.parseInt(st.nextToken());
            for (int j = 0; j < opCode; j++)
                op[count++] = (i + 1);
        }
        perm(0, new int[N - 1]);
        bw.write(max + "\n" + min);

        br.close();
        bw.close();
    }

    static void perm(int count, int[] choosed) {
        if (count == N - 1) {
            calc(choosed);
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[count] = op[i];
                perm(count + 1, choosed);
                visited[i] = false;
            }
        }

    }

    static void calc(int[] choosed) {
        int result = arr[0];
        for (int i = 0; i < N - 1; i++) {
            switch (choosed[i]) {
                case 1:
                    result += arr[i + 1];
                    break;
                case 2:
                    result -= arr[i + 1];
                    break;
                case 3:
                    result *= arr[i + 1];
                    break;
                case 4:
                    if (result < 0) {
                        result *= (-1);
                        result /= arr[i + 1];
                        result *= (-1);
                    } else result /= arr[i + 1];
                    break;
            }
        }
        max = max > result ? max : result;
        min = min < result ? min : result;

    }

}
