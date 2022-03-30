package Week6_Sort.개인;

import java.io.*;
import java.util.Arrays;

public class BOJ_S5_2822_점수_계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 8;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, (o1, o2) -> {
            return -1 * Integer.compare(o1[0], o2[0]);
        });
        int sum = 0;
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += arr[i][0];
            nums[i] = arr[i][1];

        }
        Arrays.sort(nums);
        bw.write(String.valueOf(sum));
        bw.newLine();
        for (int n : nums)
            bw.write(n + " ");

        br.close();
        bw.close();
    }
}
