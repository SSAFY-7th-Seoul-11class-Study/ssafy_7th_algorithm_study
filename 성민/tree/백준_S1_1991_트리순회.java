package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Node{
	char data;
	Node left;
	Node right;
	
	Node(char data){
		this.data = data;
	}
}

class Tree{
	public Node root;
	
	public void createNode(char data,char leftData,char rightData) {
		if(root ==null) {
			root = new Node(data);
			root.left=leftData !='.' ? new Node(leftData) : null;
			root.right=rightData !='.' ?new Node(rightData) : null;
		}else {
			searchNode(root,data,leftData,rightData);
		}
	}
	
	public void searchNode(Node node,char data,char leftData,char rightData) {
		if(node==null) {
			return;
		}else if(node.data==data) {
			node.left=leftData !='.' ? new Node(leftData) : null;
			node.right=rightData !='.' ?new Node(rightData) : null;
		}else {
			searchNode(node.left,data,leftData,rightData); 
			searchNode(node.right,data,leftData,rightData);
		}
	}
	
	// 전위 순회 root - left - right
	public void preOrder(Node node) {
		if(node !=null) {
			System.out.print(node.data);
			if(node.left!=null) {
				preOrder(node.left);
			}
			if(node.right!=null) {
				preOrder(node.right);
			}
		}
	}
	
	// 중위 순회 left - root -right
	public void inOrder(Node node) {
		if(node!=null) {
			if(node.left!=null) {
				inOrder(node.left);
			}
			System.out.print(node.data);
			if(node.right!=null) {
				inOrder(node.right);
			}
		}
		
	}
	
	// 후위 순회 left- right -root
	public void postOrder(Node node) {
		if(node!=null) {
			if(node.left!=null) {
				postOrder(node.left);
			}
			if(node.right!=null) {
				postOrder(node.right);
			}
			System.out.print(node.data);
		}
	}
}

public class 백준_S1_1991_트리순회 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n= Integer.parseInt(br.readLine());
		
		Tree t =new Tree();
		
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine()," ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right =st.nextToken().charAt(0);
			
			t.createNode(root, left, right);
		}
		
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
		
		
	}

}
