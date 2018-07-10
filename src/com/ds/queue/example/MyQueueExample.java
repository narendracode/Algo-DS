package com.ds.queue.example;

import com.ds.queue.MyQueue;
import com.ds.queue.NoElementFoundException;

public class MyQueueExample {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
				
		try {
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			//System.out.println(queue.dequeue());
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("print : ");
			queue.print();
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}

	}

}
