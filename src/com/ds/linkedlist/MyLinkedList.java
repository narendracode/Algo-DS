package com.ds.linkedlist;

public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	public int size() {
		return size;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(size == 0) {
			first = node;
		}else {
			last.setNext(node);
		}
		last = node;
		size++;
	}
	
	
	public void print() throws NoElementFoundException{
		if(size == 0)
			throw new NoElementFoundException();
		else {
			Node temp = first;
			
			while(temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		}
	}
	

	public int get(int index) throws NoElementFoundException {
		if(index >= size)
			throw new NoElementFoundException();
		else if(index == 0) {
			return first.getData();
		}
		else if(index == size - 1) {
			return last.getData();
		}
		else {
			int count = 0;
			Node node = first;
			while(count != index) {
				node = node.getNext();
				count++;
			}
			
			return node.getData();
		}
		
	}

	//remove(int index)

}
