/*
BOJ B2 2309 일곱 난쟁이
브루트 포스로 풀이
 */
package Week4_Brute_Force.개인;

import java.io.*;
import java.util.Arrays;

public class BOJ_B2_2309_일곱_난쟁이 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 9;
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum -= 100;
        int chk1 = -1;
        int chk2 = -1;

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (sum == arr[i] + arr[j]) {
                        chk1 = arr[i];
                        chk2 = arr[j];
                        break;
                    }
                }
            }
        }
        for (int n : arr) {
            if (n != chk1 && n != chk2)
                sb.append(n).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
