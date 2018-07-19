package com.ds.avl;

public class Node {
	private int data;
	private int height;
	private Node left;
	private Node right;
	
	public Node(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data+"";
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
	
	
	
}
