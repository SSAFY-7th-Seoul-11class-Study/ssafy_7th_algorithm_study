package Week5_Back_Tracking.개인;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G4_1062_가르침 {
    static int N;
    static int K;
    static int max;
    static String[] words;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replace("anta", "").replace("tica", "");
        }
        if (K < 5) bw.write(String.valueOf(0));
        else if (K >= 26)
            bw.write(String.valueOf(N));
        else {
            visited = new boolean[26];
            visited['a' - 'a'] = true;
            visited['c' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            K -=5;
            teach(0, 0);
            bw.write(String.valueOf(max));
        }
        br.close();
        bw.close();
    }

    static void teach(int count, int index) {
        if (count == K) {
            int cnt = 0;
            for (String str : words) {
                boolean chk = true;
                for (int i = 0; i < str.length(); i++) {
                    if (!visited[str.charAt(i) - 'a']) {
                        chk = false;
                        break;
                    }
                }
                if (chk) cnt++;
            }
            max = max > cnt ? max : cnt;
            return;
        }
        for (int i = index; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                teach(count + 1, i);
                visited[i] = false;
            }
        }
    }
}

