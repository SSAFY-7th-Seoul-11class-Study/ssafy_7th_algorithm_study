/*
BOJ S2 1541 잃어버린 괄호
*/
package Week3_Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 99999 + 99999 + 1;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            int temp = 0;
            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }
            if (sum == (99999 + 99999 + 1))
                sum = temp;
            else sum -= temp;
        }
        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}
