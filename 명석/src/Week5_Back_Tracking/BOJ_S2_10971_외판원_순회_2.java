/*/
BOJ S2 10971 외판원 순회 2
1. 순열로 각 도시를 돌림
2. 실패 : 도시X -> 도시Y로 갈 때에 못가는 경우를 생각 못함
3. 이 조건을 넣어주니 통과
 */
package Week5_Back_Tracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S2_10971_외판원_순회_2 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        perm(0, new int[N]);
        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    static void perm(int count, int[] choosed) {
        if (count == N) {
            boolean chk = true;
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                if (arr[choosed[i]][choosed[i + 1]] == 0) {
                    chk = false;
                    break;
                }
                sum += arr[choosed[i]][choosed[i + 1]];
            }
            if (chk) {
                if (arr[choosed[N - 1]][choosed[0]] == 0)
                    chk = false;
                else
                    sum += arr[choosed[N - 1]][choosed[0]];
            }
            if (chk) min = min < sum ? min : sum;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[count] = i;
                perm(count + 1, choosed);
                visited[i] = false;
            }
        }

    }
}
