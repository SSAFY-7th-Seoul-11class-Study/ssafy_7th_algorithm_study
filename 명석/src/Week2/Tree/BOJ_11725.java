package Week2.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 배열 원소 순서는 노드 자리, 원소값은 부모 노드를 뜻함
        int[] parents = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            // 둘 중 하나라도 1이라면 1이 부모가 됨
            if (firstNode == 1)
                parents[secondNode] = firstNode;
            else if (secondNode == 1)
                parents[firstNode] = secondNode;
            else {
                // 둘 중 부모가 이미 존재하는지 확인
                if (parents[firstNode] != 0)
                    parents[secondNode] = firstNode;
                else
                    parents[firstNode] = secondNode;
            }

        }

        for (int i = 2; i <= N; i++)
            bw.write(parents[i] + "\n");

        br.close();
        bw.close();
    }
}