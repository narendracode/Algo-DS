package com.algo.dailyproblems;

public class Node {
	private int data;
	private int id;
	private Node left;
	private Node right;

	public Node(int data) {
		super();
		this.data = data;
	}
	
	public Node(int data,int id) {
		this(data);
		this.id = id;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
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
	@Override
	public String toString() {
		return data + " "+ " id : "+id;
	}
	
	
	
}
