package Week6_Sort.개인;

import java.io.*;
import java.util.*;

public class BOJ_S5_10876_중복_빼고_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N; i++)
            set.add(Integer.parseInt(st.nextToken()));
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        for(int n : arr)
            bw.write( n + " ");
        br.close();
        bw.close();
    }
}
