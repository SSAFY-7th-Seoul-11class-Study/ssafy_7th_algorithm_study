package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node2{ // 내꺼 package에 Node가 있어서 그냥 Node2 의미 없
	int num;
	Node2 left,right;
	
	Node2(int num){
		this.num=num;
	}
	
	Node2(int num,Node2 left,Node2 right){
		this.num=num;
		this.left=left;
		this.right=right;
	}
	
	void insert(int n) {
		if(n<this.num) {
			if(this.left==null) {
				this.left=new Node2(n);
			}else {
				this.left.insert(n);
			}
		}else {
			if(this.right==null) {
				this.right=new Node2(n);
			}else {
				this.right.insert(n);
			}
		}
	}
}

public class 백준_G5_5639_이진검색트리 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		Node2 root = new Node2(Integer.parseInt(br.readLine())); // 전위 순위는 무조건 root 부터 탐색이므로 첫번째 입력 수를 root로
		//String str;
		String str="";
//		while((str=br.readLine())!=null ) { //str 초기화 안해주고  length 에 대한 조건이 없으면 백준에선 정답으로는 하지만 실행할때 Exception 발생함
//			root.insert(Integer.parseInt(str));
//		}
		
		while((str=br.readLine())!=null && str.length()!=0) { //입력 없을때까지
			root.insert(Integer.parseInt(str));
		}
		
		postOrder(root);
		bw.write(sb.toString());
		
		br.close();
		bw.close();
		
	}

	
	public static void postOrder(Node2 node) {
			if(node!=null) {
				if(node.left!=null) {
					postOrder(node.left);
				}
				if(node.right!=null) {
					postOrder(node.right);
				}
				sb.append(node.num+"\n");
			}
		}
}


