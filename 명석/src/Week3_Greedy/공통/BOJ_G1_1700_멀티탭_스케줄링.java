package Week3_Greedy.공통;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G1_1700_멀티탭_스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[K];
//        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> concent = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
//            if (map.containsKey(num))
//                map.put(num, map.get(num) + 1);
//            else map.put(num, 1);
        }
        for (int i = 0; i < K; i++) {
            if (concent.size() < N) // 콘센트에 아무것도 꽂혀있지 않을 때
                concent.add(arr[i]);
            else {

            }
        }

        br.close();
        bw.close();
    }
}
