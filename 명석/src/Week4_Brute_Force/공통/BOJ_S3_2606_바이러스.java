/*
BOJ S3 2606 바이러스
 */

package Week4_Brute_Force.공통;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_S3_2606_바이러스 {
    static LinkedList<Integer>[] nodes;
    static boolean visited[];
    static int count = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        nodes = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++)
            nodes[i] = new LinkedList<>();
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nodes[A].add(B);
            nodes[B].add(A);
        }
        DFS(1);
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }

    static void DFS(int start) {
        visited[start] = true;
        count++;
        for (int i = 0; i < nodes[start].size(); i++) {
            if (!visited[nodes[start].get(i)])
                DFS(nodes[start].get(i));
        }

    }
}
