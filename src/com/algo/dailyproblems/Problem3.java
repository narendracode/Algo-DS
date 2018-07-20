package com.algo.dailyproblems;

/*
 * This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

 */


public class Problem3 {
	public static void main(String[] args) {
		UnivalTree tree = new UnivalTree();
		tree.create1(); //3
		//tree.create2(); //5
		//tree.create3(); //2
		//tree.create4(); //2
		
		//tree.inOrderTraverse();
		tree.countUnival();
	}
}
