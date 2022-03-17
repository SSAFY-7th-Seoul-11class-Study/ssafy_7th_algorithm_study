package Week6_Sort.공통;

import java.io.*;
import java.util.Arrays;

public class BOJ_S5_1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str  = br.readLine();
        int[] arr = new int[str.length()];
        for(int i = 0 ; i<arr.length;i++){
            arr[i] = str.charAt(i) - '0';
        }
        Arrays.sort(arr);
        for(int i = arr.length-1 ; i>=0 ; i--)
            bw.write(String.valueOf(arr[i]));

        br.close();
        bw.close();
    }
}
