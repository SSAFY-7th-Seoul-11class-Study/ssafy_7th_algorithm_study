/*
BOJ G4 1339 단어 수학
 */

package Week3_Greedy.개인;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_G4_1339_단어_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= str.length(); j++) {
                char c = str.charAt(str.length() - j);
                int digit = 1 * (int) Math.pow(10, j - 1);
                if (map.containsKey(c))
                    map.put(c, map.get(c) + digit);
                else map.put(c, digit);
            }
        }
        Collection<Integer> values = map.values();
        Integer[] arr = values.toArray(new Integer[map.size()]);
        Arrays.sort(arr, Collections.reverseOrder());
        int num = 9;
        int sum = 0;
        for (int n : arr) {
            sum += (n * num--);
        }
        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}
