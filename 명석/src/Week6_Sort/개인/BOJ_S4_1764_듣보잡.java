package Week6_Sort.개인;

import java.io.*;
import java.util.*;

public class BOJ_S4_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> arr = new ArrayList<>();
        if (N >= M) {
            Set<String> dd = new HashSet<>();
            for (int i = 0; i < N; i++)
                dd.add(br.readLine());
            for (int i = 0; i < M; i++) {
                String str = br.readLine();
                if (dd.contains(str))
                    arr.add(str);
            }
        } else {
            String[] dd = new String[M];
            Set<String> bb = new HashSet<>();

            for (int i = 0; i < N; i++)
                dd[i] = br.readLine();
            for (int i = 0; i < M; i++)
                bb.add(br.readLine());

            for (String str : dd)
                if (bb.contains(str))
                    arr.add(str);
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append("\n");
        for (String s : arr)
            sb.append(s).append("\n");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
