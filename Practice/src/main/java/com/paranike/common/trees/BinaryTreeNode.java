package com.paranike.common.trees;

public class BinaryTreeNode<T> {
	T info;
	BinaryTreeNode<T> leftChild;
	BinaryTreeNode<T> rightChild;

	// creating leaf node
	public BinaryTreeNode(T info) {
		this.info = info;
		this.leftChild = null;
		this.rightChild = null;
	}

	public boolean isLeaf() {
		return (this.leftChild == null && this.rightChild == null);
	}

	public BinaryTreeNode(T info, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.info = info;
		this.leftChild = left;
		this.rightChild = right;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [info=" + info + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}

}
