package com.algo.dailyproblems;

public class UnivalTree {
	private Node root;
	
	public void create() {
		root = new Node(0);
		Node rootLeft = new Node(1);
		Node rootRight = new Node(0);
		root.setLeft(rootLeft);
		root.setRight(rootRight);
		
		Node rootRightLeft = new Node(1);
		Node rootRightRight = new Node(0);
		rootRight.setLeft(rootRightLeft);
		rootRight.setRight(rootRightRight);
		
		
		Node rootRightLeftLeft = new Node(1);
		Node rootRightLeftRight = new Node(1);
		rootRightLeft.setLeft(rootRightLeftLeft);
		rootRightLeft.setRight(rootRightLeftRight);
		
	}
	
	public void create1() {
		System.out.println("create1");
		root = new Node(1,0);
		Node rootLeft = new Node(1,1);
		Node rootRight = new Node(1,2);
		root.setLeft(rootLeft);
		root.setRight(rootRight);
		
		Node rootRightLeft = new Node(1,3);
		Node rootRightRight = new Node(1,4);
		rootRight.setLeft(rootRightLeft);
		rootRight.setRight(rootRightRight);
		
		
		rootRightRight.setRight(new Node(0,5));
		
	}
	
	public void create2() {
		root = new Node(1,0);
		Node rootLeft = new Node(1,1);
		Node rootRight = new Node(1,2);
		root.setLeft(rootLeft);
		root.setRight(rootRight);
		
		Node rootRightLeft = new Node(1,3);
		Node rootRightRight = new Node(1,4);
		
		rootRight.setLeft(rootRightLeft);
		rootRight.setRight(rootRightRight);
		
		//rootRightRight.setRight(new Node(0,5));
		
	}
	
	public void create3() {
		root = new Node(1,0);
		Node rootLeft = new Node(1,1);
		Node rootRight = new Node(1,2);
		root.setLeft(rootLeft);
		root.setRight(rootRight);
		Node rootRightRight = new Node(0,3);
		rootRight.setRight(rootRightRight);
	}
	
	
	public void create4() {
		root = new Node(8,0);
		Node rootRight = new Node(9,2);
		Node rootLeft = new Node(8,1);
		root.setRight(rootRight);
		root.setLeft(rootLeft);
	}
	
	
	public void inOrderTraverse() {
		inOrder(root);
	}
	
	public void countUnival() {
		Data data = new Data();
		inOrderUnival(root,data);
		System.out.println("count : "+data.getVal());
	}
	

	private boolean inOrderUnivalTest(Node node, int data) {
		if(node == null)
			return true;
		else 
			return (node.getData() == data) && inOrderUnivalTest(node.getLeft(),data) && inOrderUnivalTest(node.getRight(),data);
	}
	private void inOrder(Node root) {
		if(root.getLeft() != null)
			inOrder(root.getLeft());
		
		System.out.println(root);
		
		if(root.getRight() != null)
			inOrder(root.getRight());
	}
	
	private void inOrderUnival(Node root,Data data) {
		if(root.getLeft() != null)
			inOrderUnival(root.getLeft(),data);
		
		if(inOrderUnivalTest(root,root.getData())) {
			System.out.println("found unival : "+root);	
			data.increment();
			System.out.println("===============");
		}
		if(root.getRight() != null)
			inOrderUnival(root.getRight(),data);
	}
	
	
	
	
	
	
}
