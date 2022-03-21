package Week6_Sort.공통;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_10825_국영수 {
    static class student {
        String name;
        int korean;
        int english;
        int math;

        public student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    static int N;
    static student[] stus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        stus = new student[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stus[i] = new student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(stus, (o1, o2) -> {
            if (o1.korean == o2.korean) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    } else
                        return Integer.compare(o1.math, o2.math) * -1;
                } else
                    return Integer.compare(o1.english, o2.english);
            } else
                return Integer.compare(o1.korean, o2.korean) * -1;
        });
        for (student s : stus) {
            bw.write(s.name);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
