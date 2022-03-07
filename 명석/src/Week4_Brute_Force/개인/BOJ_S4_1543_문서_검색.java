/*
BOJ S4 1543 문서 겁색
 */
package Week4_Brute_Force.개인;

import java.io.*;

public class BOJ_S4_1543_문서_검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String chk = br.readLine();
        int i = 0;
        int count = 0;
        while (i <= input.length() - chk.length()) {
            String str = input.substring(i, i + chk.length());
            if (str.equals(chk)) {
                count++;
                i += chk.length();
            } else i++;

        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
