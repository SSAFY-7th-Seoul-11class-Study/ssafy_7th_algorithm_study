package Week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        int count = 0;
        int i = 0;
        while (size-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                nums[i++] = num;
                count++;
            } else {
                i--;
                count--;
            }
        }
        int result = 0;
        for (int j = 0; j < count; j++)
            result += nums[j];
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
}
