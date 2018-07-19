package com.ds.avl.example;

import com.ds.avl.AvlTree;

public class AvlTreeExample {

	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
		tree.insert(5);
		tree.insert(8);
		tree.insert(7);
		tree.insert(4);
		tree.insert(3);
		tree.insert(1);
		
		tree.traverse();
		
		System.out.println("delete");
		
		tree.delete(7);
		tree.traverse();
		
	}

}
