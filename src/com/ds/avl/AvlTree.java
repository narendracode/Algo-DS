package com.ds.avl;

public class AvlTree implements Tree{
	private Node root;
	
	private Node rightRotation(Node node) {
		System.out.println("Rotating to the right of node : "+node.getData());
		Node tempNode = node.getLeft();
		node.setLeft(tempNode.getRight());
		tempNode.setRight(node);
		
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		tempNode.setHeight(Math.max(height(tempNode.getLeft()), height(tempNode.getRight())) + 1);
		
		return tempNode;
	}
	
	private Node leftRotation(Node node) {
		System.out.println("Rotating to the left of node : "+node.getData());
		Node tempNode = node.getRight();
		node.setRight(tempNode.getLeft());
		tempNode.setLeft(node);
		return tempNode;
	}
	
	
	private int height(Node node) {
		if(node == null)
			return -1;
		
		return node.getHeight();
	}
	
	private int getBalance(Node node) {
		if (node == null) {
			return 0;
		}

		return height(node.getLeft()) - height(node.getRight());
	}
	
	@Override
	public void insert(int data) {
		root = insertNode(root,data);
	}

	
	private Node insertNode(Node node, int data) {
		
		if(node == null)
			return new Node(data);
		
		 if(data < node.getData()) {
			//add to left
			node.setLeft(insertNode(node.getLeft(),data));
		}else {
			node.setRight(insertNode(node.getRight(),data));
		}
		
		//System.out.println("data  : "+data+" ,Left Node  : "+node.getLeft()+"   ,Right Node : "+node.getRight());
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		System.out.println("Before settle violation : "+node);
		node = settleViolation(data,node);
		
		return node;
	}
	
	
	private Node settleViolation(int data, Node node) {

		int balance = getBalance(node);

		// this is the Case I !!!! left-left
		if (balance > 1 && data < node.getLeft().getData()) {
			System.out.println("Tree is left left heavy...");
			return rightRotation(node);
		}

		// this is the Case II right-right !!!!
		if (balance < -1 && data > node.getRight().getData()) {
			System.out.println("Tree is right right heavy...");
			return leftRotation(node);
		}

		// left right situation
		if (balance > 1 && data > node.getLeft().getData()) {
			System.out.println("Tree is left right heavy...");
			node.setLeft(leftRotation(node.getLeft()));
			return rightRotation(node);
		}

		// right left situation
		if (balance < -1 && data < node.getRight().getData()) {
			System.out.println("Tree is right left heavy...");
			node.setRight(rightRotation(node.getRight()));
			return leftRotation(node);
		}

		return node;
	}

	@Override
	public void traverse() {
		if(root == null)
			return;
		
		inOrder(root);
	}

	private void inOrder(Node node) {
		if(node.getLeft() != null)
			inOrder(node.getLeft());
		
		//System.out.println(node.getData());
		System.out.println(node);
		
		if(node.getRight() != null)
			inOrder(node.getRight());
	}

	@Override
	public int delete(int data) {
		return delete(root,data).getData();
	}
	private Node delete(Node node, int data) {

		if (node == null)
			return node;

		// first we have to look for the node we want to get rid of
		if (data < node.getData()) {  // data smaller than given node's data -> go to the left recursively
			node.setLeft(delete(node.getLeft(), data));
		} else if (data > node.getData()) { // data greater than given node's data -> go to the right recursively
			node.setRight(delete(node.getRight(), data));
		} else {  // we have found the node we want to remove !!!

			if (node.getLeft() == null && node.getRight() == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if (node.getLeft() == null) {
				System.out.println("Removing the right child...");
				Node tempNode = node.getRight();
				node = null;
				return tempNode;
			} else if (node.getRight() == null) {
				System.out.println("Removing the left child...");
				Node tempNode = node.getLeft();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node tempNode = getPredecessor(node.getLeft());

			node.setData(tempNode.getData());
			node.setLeft(delete(node.getLeft(), tempNode.getData()));
		}

		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

		// have to check on every delete operation whether the tree has become unbalanced or not !!!
		return settleDeletion(node);
	}

	
	private Node settleDeletion(Node node) {
		
		int balance = getBalance(node);

		// OK, we know the tree is left heavy BUT it can be left-right heavy or left-left heavy
		if (balance > 1) {
			
			// left right heavy situation: left rotation on parent + right rotation on grandparent
			if (getBalance(node.getLeft()) < 0) {
				node.setLeft(leftRotation(node.getLeft()));
			}

			// this is the right rotation on grandparent ( if left-left heavy, thats single right rotation is needed
			return rightRotation(node);
		}

		// OK, we know the tree is right heavy BUT it can be left-right heavy or right-right heavy
		if (balance < -1) {
			// right - left heavy so we need a right rotation ( on parent!!! ) before left rotation
			if (getBalance(node.getRight()) > 0) {
				node.setRight(rightRotation(node.getRight()));
			}

			// left rotation on grand parent
			return leftRotation(node);
		}

		return node;
	}

	private Node getPredecessor(Node node) {

		Node predecessor = node;

		while (predecessor.getRight() != null)
			predecessor = predecessor.getRight();

		return predecessor;
	}
	
	
}
