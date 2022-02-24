package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1068_트리 {

    static int N;
    static LinkedList<Integer>[] tree;
    static int root;
    static int removeNode;
    static int removeParent;

    public static int findLeafNode(int current) {
        if(tree[current].isEmpty()) {
            return  1;
        }
        int sum = 0;
        for(int i = 0; i < tree[current].size(); i++) {
            sum += findLeafNode(tree[current].get(i));
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new LinkedList[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }

        StringTokenizer token = new StringTokenizer(br.readLine());
        removeNode = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(token.nextToken());
            if(parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }

            if(i == removeNode) {
                removeParent = parent;
            }
        }

        if(removeNode != root) {
            tree[removeParent].remove(tree[removeParent].indexOf(removeNode));
            System.out.println(findLeafNode(root));
        } else {
            System.out.println(0);
        }
    }
}
