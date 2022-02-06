/*
1991 트리순회
 */
package Week2_Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;


class Tree {
    class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    Node root;

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node root, char data, char leftData, char rightData) {
        if (root == null) {
            return;
        } else if (root.data == data) {
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }

    public StringBuilder preorder(StringBuilder sb, Node root) {
        sb.append(root.data);
        if (root.left != null)
            preorder(sb, root.left);
        if (root.right != null)
            preorder(sb, root.right);
        return sb;
    }

    public StringBuilder inorder(StringBuilder sb, Node root) {
        if (root.left != null)
            inorder(sb, root.left);
        sb.append(root.data);
        if (root.right != null)
            inorder(sb, root.right);
        return sb;
    }

    public StringBuilder postorder(StringBuilder sb, Node root) {
        if (root.left != null)
            postorder(sb, root.left);
        if (root.right != null)
            postorder(sb, root.right);
        sb.append(root.data);
        return sb;
    }

}

public class BOJ_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.createNode(node, left, right);
        }
        bw.write(tree.preorder(new StringBuilder(), tree.root).toString());
        bw.newLine();
        bw.write(tree.inorder(new StringBuilder(), tree.root).toString());
        bw.newLine();
        bw.write(tree.postorder(new StringBuilder(), tree.root).toString());
        bw.newLine();

        br.close();
        bw.close();
    }
}
