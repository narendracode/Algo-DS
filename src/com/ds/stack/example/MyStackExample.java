package com.ds.stack.example;

import com.ds.stack.MyStack;
import com.ds.stack.NoElementFoundException;

public class MyStackExample {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
	
		System.out.println("Elements present in stack : ");
		stack.print();
		
		System.out.println("***");
		try {
			System.out.println("pop : "+stack.pop());
			System.out.println("pop : "+stack.pop());
			System.out.println("pop : "+stack.pop());
			System.out.println("pop : "+stack.pop());
			//System.out.println("pop : "+stack.pop());
			//System.out.println("pop : "+stack.pop());
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
		
		
	}//main

}
