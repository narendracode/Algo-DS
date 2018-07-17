package com.ds.bst.example;

import com.ds.bst.BinarySearchTree;
import com.ds.bst.Tree;

public class BinarySearchTreeExample {
	public static void main(String[] args) {
		Tree<Integer> bst = new BinarySearchTree<>();
		
		bst.insert(10);
		bst.insert(4);
		bst.insert(5);
		bst.insert(16);
		bst.insert(200);
		
		System.out.println("In order : ");
		bst.inOrder();
		
		System.out.println("Pre Order : ");
		bst.preOrder();
		
		System.out.println("Post Order : ");
		bst.postOrder();
		
		System.out.println("Min : "+bst.getMin());
		System.out.println("Max : "+bst.getMax());
		
		bst.delete(10);
		System.out.println("In order : ");
		bst.inOrder();
		
		
		bst.delete(16);
		System.out.println("In order : ");
		bst.inOrder();
	}
}
