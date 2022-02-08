/*
5639 이진검색트리
 */
package Week2_Tree;

import java.io.*;

public class BOJ_5639 {
    static StringBuilder sb = new StringBuilder();

    static private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        public void createNode(int data) {

            if (this.data > data) {
                if (this.left == null)
                    this.left = new Node(data);
                else this.left.createNode(data);
            } else {
                if (this.right == null)
                    this.right = new Node(data);
                else this.right.createNode(data);
            }

        }

        public void postorder(Node root) {
            if (root.left != null)
                postorder(root.left);
            if (root.right != null)
                postorder(root.right);
            sb.append(root.data + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            int nodeData = Integer.parseInt(input);
            root.createNode(nodeData);
        }

        root.postorder(root);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
