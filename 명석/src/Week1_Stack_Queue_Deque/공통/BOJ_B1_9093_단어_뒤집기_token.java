/*
9093 단어 뒤집기
StringTokenizer 로 풀이
 */

package Week1_Stack_Queue_Deque.공통;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_B1_9093_단어_뒤집기_token {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int stCount = st.countTokens();
            for (int j = 0; j < stCount; j++) {
                String str = st.nextToken();
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
