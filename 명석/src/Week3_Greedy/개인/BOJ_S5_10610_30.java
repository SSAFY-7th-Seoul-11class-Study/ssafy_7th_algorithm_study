package Week3_Greedy.개인;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_S5_10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int N = input.length();
        Integer[] arr = new Integer[N];
        int nums[] = new int[10];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = input.charAt(i) - '0';
            sum += arr[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        if (sum % 3 == 0 && arr[N - 1] == 0)
            for (int n : arr)
                sb.append(n);
        else
            sb.append(-1);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
// 순열로 풀이 -> 시간초과
//public class BOJ_S5_10610_30 {
//    static int[] arr;
//    static boolean[] visited;
//    static int[] choosed;
//    static int N, max;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String input = br.readLine();
//        N = input.length();
//        arr = new int[N];
//        visited = new boolean[N];
//        choosed = new int[N];
//        max = -1;
//        for (int i = 0; i < N; i++)
//            arr[i] = input.charAt(i) - '0';
//        perm(0);
//        bw.write(String.valueOf(max));
//        br.close();
//        bw.close();
//    }
//
//    static void perm(int count) {
//        if (count == N) {
//            int sum = 0;
//            for (int i = 0; i < N; i++)
//                sum += (choosed[i] * Math.pow(10, N - 1 - i));
//            if (sum % 30 == 0)
//                max = Math.max(max, sum);
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                choosed[count] = arr[i];
//                perm(count + 1);
//                visited[i] = false;
//            }
//        }
//    }
//}


