/*
9093 단어 뒤집기
String split 으로 풀이
 */

package Week1_Stack_Queue_Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ_9093_split {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] strs = br.readLine().split(" ");

            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                for (int k = str.length() - 1; k >= 0; k--)
                    bw.write(String.valueOf(str.charAt(k)));
                bw.write(" ");
            }
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
