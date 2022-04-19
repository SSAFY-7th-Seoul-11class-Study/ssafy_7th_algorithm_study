/*
BOJ S4 2503 숫자 야구
 */
package Week4_Brute_Force.공통;

import java.io.*;
import java.util.StringTokenizer;

public class BOj_S4_2503_숫자야구 {
    static int N;
    static int[][] arr;
    static int result;
    static int[] nums;
    static int[] choosed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        choosed = new int[3];
        arr = new int[N][5];
        result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            arr[i][0] = num.charAt(0) - '0';
            arr[i][1] = num.charAt(1) - '0';
            arr[i][2] = num.charAt(2) - '0';
            arr[i][3] = Integer.parseInt(st.nextToken());
            arr[i][4] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    static void perm(int count) {
        if (count == 3) {
            if (choosed[0] != choosed[1] && choosed[0] != choosed[2] && choosed[1] != choosed[2])
                if (check(choosed)) result++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            choosed[count] = nums[i];
            perm(count + 1);
        }
    }

    static boolean check(int input[]) {
        for (int i = 0; i < N; i++) {
            int s = 0;
            int b = 0;
            for (int j = 0; j < 3; j++) { // 스트라이크 체크
                if (input[j] == arr[i][j]) s++;
            }
            for (int j = 0; j < 3; j++) { // 볼 체크
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    else if (input[j] == arr[i][k])
                        b++;
                }
            }
            if (s != arr[i][3] || b != arr[i][4])
                return false;
        }
        return true;
    }
}
