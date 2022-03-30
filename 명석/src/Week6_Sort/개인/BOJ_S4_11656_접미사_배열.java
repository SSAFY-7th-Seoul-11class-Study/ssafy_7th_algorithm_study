package Week6_Sort.개인;

import java.io.*;
import java.util.Arrays;

public class BOJ_S4_11656_접미사_배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] strs = new String[str.length()];
        for(int i = 0; i<str.length();i++){
            strs[i] = str.substring(i, str.length());
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for(String s : strs )
            sb.append(s).append("\n");

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
