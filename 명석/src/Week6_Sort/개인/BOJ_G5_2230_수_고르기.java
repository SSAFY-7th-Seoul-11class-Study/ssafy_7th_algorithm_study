package Week6_Sort.개인;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G5_2230_수_고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int M= Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i< N ; i++)
            arr[i] =  Integer.parseInt(br.readLine());

        br.close();
        bw.close();
    }
}
