package com.paranike.common.trees;

import java.util.Stack;

public class TreeZigZagTraversal {

	public void visitAllNodesZigZag(BinaryTreeNode<String> root) {
		if (root == null) {
			return;
		}
		Stack<BinaryTreeNode<String>> leftStack = new Stack<BinaryTreeNode<String>>();
		Stack<BinaryTreeNode<String>> rightStack = new Stack<BinaryTreeNode<String>>();
		leftStack.push(root);

		while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
			while (!leftStack.isEmpty()) {
				BinaryTreeNode<String> node = leftStack.pop();
				if (node != null) {
					System.out.println(node.getInfo());
					if (node.getLeftChild() != null) {
						rightStack.push(node.getLeftChild());
					}
					if (node.getRightChild() != null) {
						rightStack.push(node.getRightChild());
					}
				}
			}
			while (!rightStack.isEmpty()) {
				BinaryTreeNode<String> node = rightStack.pop();
				if (node != null) {
					System.out.println(node.getInfo());
					if (node.getRightChild() != null) {
						leftStack.push(node.getRightChild());
					}
					if (node.getLeftChild() != null) {
						leftStack.push(node.getLeftChild());
					}

				}
			}

		}
	}

	public static void main(String[] args) {
		TreeZigZagTraversal obj = new TreeZigZagTraversal();
		BinaryTreeNode<String> one = new BinaryTreeNode<String>("1");
		BinaryTreeNode<String> two = new BinaryTreeNode<String>("2");

		BinaryTreeNode<String> three = new BinaryTreeNode<String>("3");

		BinaryTreeNode<String> four = new BinaryTreeNode<String>("4");

		BinaryTreeNode<String> five = new BinaryTreeNode<String>("5");

		BinaryTreeNode<String> six = new BinaryTreeNode<String>("6");

		BinaryTreeNode<String> seven = new BinaryTreeNode<String>("7");

		one.setLeftChild(two);
		one.setRightChild(three);

		two.setLeftChild(seven);
		two.setRightChild(six);

		three.setLeftChild(five);
		three.setRightChild(four);

		obj.visitAllNodesZigZag(one);

	}

}
