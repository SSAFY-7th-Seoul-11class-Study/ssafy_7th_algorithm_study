/*
11725 트리의 부모 찾기
1. 처음엔 각 노드별 부모를 저장하는 배열을 사용 -> 반례 확인
11
1 3
9 10
1 9
3 7
3 4
7 6
2 11
5 2
7 5
7 8
-> 2 11 에서 2가 부모가 되어야하는데 랜덤으로 설정하게 됨.
어느 반례가 나오더라도 성공을 보장 못함

2. 1이 무조건 루트노드이므로 각 노드를 간선으로 연결 후
DFS를 돌리면 각 노드를 순회하면서 부모를 체크한다.
* */
package Week2_Tree.공통;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2_11725_트리의_부모_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 들어갈 번호의 수
        List<Integer>[] tree = new ArrayList[N + 1]; // 트리
        int[] parents = new int[N + 1]; // 각 노드가 가르키는 부모를 저장하는 배열
        //트리 입력
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            if (tree[firstNode] == null)
                tree[firstNode] = new ArrayList<>();
            if (tree[secondNode] == null)
                tree[secondNode] = new ArrayList<>();
            tree[firstNode].add(secondNode);
            tree[secondNode].add(firstNode);
        }
        // DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int i = 0; i < tree[node].size(); i++) {
                int child = tree[node].get(i);
                if (!visited[child]) {
                    parents[child] = node;
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }


        for (int i = 2; i <= N; i++)
            bw.write(parents[i] + "\n");

        br.close();
        bw.close();
    }
}