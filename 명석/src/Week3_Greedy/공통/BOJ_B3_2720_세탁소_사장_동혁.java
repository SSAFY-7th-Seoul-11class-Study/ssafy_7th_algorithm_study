/*
BOJ B3 2720 세탁소 사장 동혁
*/
package Week3_Greedy.공통;

import java.io.*;

public class BOJ_B3_2720_세탁소_사장_동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};
        for (int tc = 0; tc < testCase; tc++) {
            StringBuilder sb = new StringBuilder();
            int money = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                if (money >= coins[i])
                    sb.append(money / coins[i]).append(" ");
                else sb.append(0).append(" ");
                money %= coins[i];
            }
            bw.write(sb.append("\n").toString());
        }

        br.close();
        bw.close();
    }
}
