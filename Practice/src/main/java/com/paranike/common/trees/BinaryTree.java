package com.paranike.common.trees;

import java.util.LinkedList;
import java.util.Stack;

import com.paranike.common.NodeInfoProcessor;

public class BinaryTree<T> {
	private BinaryTreeNode<T> root;

	public BinaryTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	private void visitNode(BinaryTreeNode<T> node, NodeInfoProcessor<T> processor) {
		if (node == null)
			return;
		else
			processor.processNode(node.getInfo());

	}

	// Root, Left, Right PreOrder
	public void preOrder(BinaryTreeNode<T> inputNode, NodeInfoProcessor<T> processor) {
		if (inputNode == null)
			return;
		visitNode(inputNode, processor);
		preOrder(inputNode.getLeftChild(), processor);
		preOrder(inputNode.getRightChild(), processor);
	}

	// Left, Root, Right InOrder
	public void inOrder(BinaryTreeNode<T> inputNode, NodeInfoProcessor<T> processor) {
		if (inputNode == null)
			return;
		inOrder(inputNode.getLeftChild(), processor);
		visitNode(inputNode, processor);

		inOrder(inputNode.getRightChild(), processor);
	}

	// Left, Right, Root postOrder
	public void postOrder(BinaryTreeNode<T> inputNode, NodeInfoProcessor<T> processor) {
		if (inputNode == null)
			return;
		postOrder(inputNode.getLeftChild(), processor);
		postOrder(inputNode.getRightChild(), processor);
		visitNode(inputNode, processor);
	}

	public void visitAllNodesWithBFS(BinaryTreeNode<T> rootNode, NodeInfoProcessor<T> processor) {
		if (rootNode == null) {
			return;
		}
		LinkedList<BinaryTreeNode<T>> q = new LinkedList<BinaryTreeNode<T>>();
		q.add(rootNode);
		while (!q.isEmpty()) {
			BinaryTreeNode<T> currentNode = q.poll();
			if (currentNode == null)
				continue;
			q.add(currentNode.getLeftChild());
			q.add(currentNode.getRightChild());
			visitNode(currentNode, processor);
		}
	}

	public void zigZagTry(BinaryTreeNode<T> rootNode, NodeInfoProcessor<T> processor, boolean isLtoRDir) {
		if (rootNode == null) {
			return;
		}
		LinkedList<BinaryTreeNode<T>> q = new LinkedList<BinaryTreeNode<T>>();
		q.add(rootNode);
		while (!q.isEmpty()) {
			BinaryTreeNode<T> currentNode = q.poll();
			if (currentNode == null)
				continue;
			if (isLtoRDir) {
				q.add(currentNode.getLeftChild());
				q.add(currentNode.getRightChild());
				isLtoRDir = !isLtoRDir;
			} else {
				q.add(currentNode.getRightChild());
				q.add(currentNode.getLeftChild());
				isLtoRDir = !isLtoRDir;
			}

			visitNode(currentNode, processor);
		}
	}

	public void visitAllNodesWithDFS(BinaryTreeNode<T> rootNode, NodeInfoProcessor<T> processor) {
		if (rootNode == null) {
			return;
		}
		Stack<BinaryTreeNode<T>> s = new Stack<BinaryTreeNode<T>>();
		s.add(rootNode);
		while (!s.isEmpty()) {
			BinaryTreeNode<T> node = s.pop();

			BinaryTreeNode<T> leftNode = node.getLeftChild();
			BinaryTreeNode<T> rightNode = node.getRightChild();

			if (rightNode != null)
				s.push(rightNode);
			if (leftNode != null)
				s.push(leftNode);
			visitNode(node, processor);
		}
	}
}