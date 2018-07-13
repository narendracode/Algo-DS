package com.ds.linkedlist.example;

import com.ds.linkedlist.MyLinkedList;
import com.ds.linkedlist.NoElementFoundException;

public class LinkedListExample {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		try {
			System.out.println("Total element in list : "+list.size());
			list.print();
			
			System.out.println("element at index 2 : "+list.get(2));
			System.out.println("element at index 3 : "+list.get(3));
		} catch (NoElementFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
