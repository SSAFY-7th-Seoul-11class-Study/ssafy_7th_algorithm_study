/*
BOJ B4 10162 전자레인지
 */

package Week3_Greedy.개인;

import java.io.*;

public class BOJ_B4_10162_전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] buttons = {300, 60, 10};
        if (T % 10 == 0) {
            for (int i = 0; i < buttons.length; i++) {
                sb.append(T / buttons[i]).append(" ");
                T %= buttons[i];
            }

        } else sb.append(-1);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
