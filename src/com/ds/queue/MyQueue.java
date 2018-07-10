package com.ds.queue;

public class MyQueue {
	private Node front;
	private Node rear;
	
	
	public void enqueue(int data) {
		Node node = new Node(data);
		if(front == null && rear == null) {
			front = node;
			rear = node;
		}else {
			rear.setNext(node);
			rear = node;
		}
	}
	
	public int dequeue() throws NoElementFoundException{
		if(front == null || rear == null) {
			throw new NoElementFoundException();
		}else {
			if(front != rear) {
				int data = front.getData();
				front = front.getNext();
				return data;
			}else {
				int data = front.getData();
				front = null;
				rear = null;
				return data;
			}
		}
	}
	
	
	public int peak() {
		return front.getData();
	}
	
	public void print() throws NoElementFoundException{
		if(front == null || rear == null) {
			throw new NoElementFoundException();
		}else {
			Node temp = front;
			while(temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		}
	}
	
	
	
}
