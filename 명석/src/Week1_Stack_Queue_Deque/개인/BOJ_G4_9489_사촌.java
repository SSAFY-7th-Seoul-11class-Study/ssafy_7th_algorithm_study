/*
9489 사촌
각 노드를 트리로, 조건에 따라 부모 설정하는 배열을 만들어 값 입력
루트노드는 부모가 X -> parent[0] = -1;
사촌인 경우 : 각 노드의 부모의 부모 노드( 레벨+2)가 같으나 노드의 부모가 다른 경우
 */
package Week1_Stack_Queue_Deque.개인;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_G4_9489_사촌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 & k == 0) break;
            // 트리
            int[] tree = new int[n + 1];
            // 부모 정보 입력할 배열
            int[] parent = new int[n + 1];
            // K가 몇번쨰 인덱스인지?
            int chk = 0;
            st = new StringTokenizer(br.readLine());
            int i = 1;
            while (st.hasMoreTokens()) {
                tree[i] = Integer.parseInt(st.nextToken());
                if (tree[i] == k) chk = i;
                i++;
            }

            // 조회하기
            int result = 0;
            // 루트 노드 부모
            parent[0] = -1;
            parent[1] = 0;
            // 부모 노드 설정
            int index = 1;
            for (int j = 2; j <= n; j++) {
                parent[j] = index;
                if (j < n)
                    if (tree[j] != tree[j + 1] - 1)
                        index++;
            }

            for (int j = 1; j <= n; j++) {
                if (parent[parent[j]] == parent[parent[chk]])
                    if (parent[j] != parent[chk])
                        result++;
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
