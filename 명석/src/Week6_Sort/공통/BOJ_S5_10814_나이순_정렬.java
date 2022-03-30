package Week6_Sort.공통;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S5_10814_나이순_정렬 {
    static int N;
    static info[] arr;

    static class info {
        int age;
        String name;

        public info(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new info[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new info(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(arr, new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                return o1.age - o2.age;
            }
        });


        for (int i = 0; i < N; i++) {
            bw.write(arr[i].age + " " + arr[i].name + "\n");
        }
        br.close();
        bw.close();
    }
}
