/*
BOJ 1068 트리
1. 리스트 배열 생성_각 노드가 갖고 있는 자식
2. 처음엔 삭제를 할떄 해당 노드부터 그 자식까지 싹 다 삭제하려고 함
3. 계속해서 오류

-> 생각해보니 그냥 해당 노드만 삭제하면 되는 일이었음.
   왜냐하면, 삭제할 노드의 부모에선 이미 자식으로 간주하지 않기 떄문에
   리프 노드를 조사할때 나머지 삭제 노드의 자식들은 조사하지 않았음...

-> 그러므로 각 리스트 배열에서 해당 노드를 자식으로 갖고 있는 리스트에서
   해당 노드를 삭제하고 리프노드 조회로 수정
 */

package Week2_Tree.공통;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_1068_트리 {
    static int N;
    static ArrayList<Integer>[] childs;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 노드의 갯수 N
        N = Integer.parseInt(br.readLine());
        // 각 노드별 자식을 저장할 childs
        childs = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            childs[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 루트 노드
        int rootNode = -1;
        // 자식 노드를 돌려가며 부모 노드에 자식 노드 넣기
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                rootNode = i;
                continue;
            }
            childs[parent].add(i);
        }
        // 삭제할 노드
        int removeNode = Integer.parseInt(br.readLine());
        // 노드를 삭제할 시
        if (removeNode == rootNode) {
            bw.write("0");
        }
        // 삭제 -> 리프노드 조사 -> 카운트 출력
        else {
            removeChild(removeNode);
            checkLeafCount(rootNode);
            bw.write(String.valueOf(count));
        }
        br.close();
        bw.close();
    }

    static void removeChild(int removeNode) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < childs[i].size(); j++)
                if (childs[i].get(j) == removeNode)
                    childs[i].remove(j);
        }
    }

    static void checkLeafCount(int rootNode) {
        if (childs[rootNode].size() == 0) {
            count++;
            return;
        }
        for (int i = 0; i < childs[rootNode].size(); i++)
            checkLeafCount(childs[rootNode].get(i));
    }
}