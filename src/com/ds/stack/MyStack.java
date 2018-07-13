package com.ds.stack;

public class MyStack {
	private Node top;
	
	
	public void push(int data) {
		Node node = new Node(data);
		if(top == null) {
			top = node;
		}else {
			node.setNext(top);
			top = node;
		}
	}
	
	public int peek() throws NoElementFoundException{
		if(top == null) {
			throw new NoElementFoundException();
		}else {
			return top.getData();
		}
	}
	
	
	public int pop() throws NoElementFoundException{
		if(top == null) {
			throw new NoElementFoundException();
		}else {
			int data = top.getData();
			top = top.getNext();
			return data;
		}
	}
	
	public void print() {
		if(top == null) { 
			System.out.println("No element present in stack");
		}else {
			Node n = top;
			while(n != null) {
				System.out.println(n.getData());
				n = n.getNext();
			}
		}
	}
	
}
