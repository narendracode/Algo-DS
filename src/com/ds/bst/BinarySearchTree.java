package com.ds.bst;

public class BinarySearchTree<T extends Comparable<T> >  implements Tree<T>{
	private Node<T> root;
	

	@Override
	public void delete(T data) {
		/*
		 * Delete has three case : 
		 * 1. Node to be deleted is leaf node
		 * 2. Node to be deleted has only one child
		 * 3. Node to be deleted has two child
		 * 
		 * #1 if node is leaf then mark the reference of it parent to null child
		 * #2 The child of node to be deleted will be referenced by it's parent
		 * #3 find the predecessor, swap the value and delete the predecessor node(which is nothing but leaf node)
		 * 
		 * Note : for Predecessor we will consider max value from left sub tree.
		 */
		if(root != null)
			root = delete(root,data);
		
		
		
	}
	
	private Node<T> delete(Node<T> node,T data){
		if(node == null)
			return node;
		
		if(data.compareTo(node.getData()) < 0) {
			node.setLeft(delete(node.getLeft(),data));
		}else if(data.compareTo(node.getData()) > 0) {
			node.setRight(delete(node.getRight(),data));
		}else {
			//found the node to be deleted.
			if(node.getLeft() == null && node.getRight() == null) {
				//it is leaf node;
				return null;
			}else if(node.getLeft() == null ) {
				Node<T> tempNode = node.getRight();
				node = null;
				return tempNode;
			}else if(node.getRight() == null ) {
				Node<T> tempNode = node.getLeft();
				node = null;
				return tempNode;
		    }
			
			Node<T> tempNode = getPredecessor(node.getLeft());
			node.setData(tempNode.getData());
			node.setLeft(delete(node.getLeft(),tempNode.getData()));
			
		}
		
		
		return node;
	}
	
	
	
	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRight() != null)
			return getPredecessor(node.getRight());
		else
			return node;
	}

	@Override
	public void insert(T newData) {
		if(root == null)
			root = new Node<T>(newData);
		else {
			insertNode(newData,root);
		}
	}

	private void insertNode(T newData, Node<T> node) {
		if(node.getData().compareTo(newData) > 0) { //root node is greater than newData
			if(node.getLeft() == null)
				node.setLeft(new Node<T>(newData));
			else
				insertNode(newData,node.getLeft());
		}
		if(node.getData().compareTo(newData) < 0) { //root node is less than newData
			if(node.getRight() == null)
				node.setRight(new Node<T>(newData));
			else
				insertNode(newData,node.getRight());
		}
	}
	


	@Override
	public T getMax() {
		return getMaxNode(root).getData();
	}
	
	private Node<T> getMaxNode(Node<T> root){
		if(root.getRight() != null)
			return getMaxNode(root.getRight());
		else
			return root;
	}
	
	private Node<T> getMinNode(Node<T> root){
		if(root.getLeft() != null)
			return getMinNode(root.getLeft());
		else
			return root;
	}
	

	@Override
	public T getMin() {
		return getMinNode(root).getData();
	}

	@Override
	public void inOrder() {
		inOrderTraverse(root);
		System.out.println();
	}
	

	public void inOrderTraverse(Node<T> root) {
		if(root.getLeft() != null)
			inOrderTraverse(root.getLeft());
		
		System.out.print(root);
		
		if(root.getRight() != null)
			inOrderTraverse(root.getRight());
	}

	@Override
	public void preOrder() {
		preOrderTraverse(root);
		System.out.println();
	}
	
	private void preOrderTraverse(Node<T> root) {
		System.out.print(root);
		
		if(root.getLeft() != null)
			preOrderTraverse(root.getLeft());
		
		if(root.getRight() != null)
			preOrderTraverse(root.getRight());
	}

	@Override
	public void postOrder() {
		postOrderTraverse(root);
		System.out.println();
	}
	
	private void postOrderTraverse(Node<T> root) {
		if(root.getLeft() != null)
			postOrderTraverse(root.getLeft());
		
		if(root.getRight() != null)
			postOrderTraverse(root.getRight());
		
		System.out.print(root);
	}

}
