package 백준.트리;

import java.util.Scanner;

//1991번(트리 순회)

public class TreeTraversal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		Tree tree = new Tree();
		
		for(int i = 0; i < tc; i++) {
			tree.add(sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
		}
		
		sc.close();
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}

}

class Node {
	char data;
	Node left, right;

	public Node(char data) {
		this.data = data;
	}

}

class Tree {
	Node root;

	public void add(char data, char left, char right) {
		if (root == null) {
			if (data != '.') {
				root = new Node(data);
			}
			if (left != '.') {
				root.left = new Node(left);
			}
			if (right != '.') {
				root.right = new Node(right);
			}
		} else {
			search(root, data, left, right);
		}
	}

	public void search(Node root, char data, char left, char right) {
		// 도착한 노드가 null이면 종료 = 삽입 위치를 찾지 못한 경우
		if (root == null) {
			return;
		}
		// 삽입 위치를 찾은 경우
		else if (root.data == data) {
			if(left != '.') {
				root.left = new Node(left);
			}
			
			if(right != '.') {
				root.right = new Node(right);
			}
		}
		// 아직 찾지 못한 경우
		else {
			search(root.left, data, left, right);
			search(root.right, data, left, right);
		}
	}
	
	//전위 : 중앙 -> 좌 -> 우
	public void preOrder(Node root) {
		System.out.print(root.data);
		if(root.left != null) preOrder(root.left);
		if(root.right != null) preOrder(root.right);
	}
	
	//중위 : 좌 -> 중앙 -> 우
	public void inOrder(Node root) {
		if(root.left != null) inOrder(root.left);
		System.out.print(root.data);
		if(root.right != null) inOrder(root.right);
	}
	
	//후위 : 좌 -> 우 -> 중앙
	public void postOrder(Node root) {
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		System.out.print(root.data);
	}
}
