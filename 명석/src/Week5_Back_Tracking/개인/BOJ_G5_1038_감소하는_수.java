package Week5_Back_Tracking.개인;

import java.io.*;

public class BOJ_G5_1038_감소하는_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        if(cnt < 10)
            bw.write(String.valueOf(cnt));
        else if(cnt > 1022)
            bw.write(String.valueOf(-1));
        else{

        }
        br.close();
        bw.close();
    }
    static void count (int cnt){

    }
}
