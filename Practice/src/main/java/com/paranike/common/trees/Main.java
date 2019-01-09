package com.paranike.common.trees;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("Root");
		BinaryTreeNode<String> l1 = new BinaryTreeNode<String>("L1");
		BinaryTreeNode<String> r1 = new BinaryTreeNode<String>("R1");

		BinaryTreeNode<String> l2 = new BinaryTreeNode<String>("L2");
		BinaryTreeNode<String> r2 = new BinaryTreeNode<String>("R2");
		root.setLeftChild(l1);
		root.setRightChild(r1);

		l1.setLeftChild(l2);
		l1.setRightChild(r2);
		BinaryTree<String> myTree = new BinaryTree<>(root);
		// Root, Left, Right PreOrder
		// Left, Root, Right InOrder
		// Left, Right, Root postOrder
		myTree.preOrder(root, (x) -> System.out.println(x));
		System.out.println("------------");
		myTree.inOrder(root, (x) -> System.out.println(x));
		System.out.println("------------");
		myTree.postOrder(root, (x) -> System.out.println(x));

		System.out.println("ZZZZZZZZZZZZZ");
		myTree.visitAllNodesWithBFS(root, (x) -> System.out.println(x));
		System.out.println("ZZZZZZZZZZZZZ");
		myTree.visitAllNodesWithDFS(root, (x) -> System.out.println(x));
		// System.out.println(5.0 % 2);

		// BinaryTreeNode<String> r = new BinaryTreeNode<String>(elems[0]);
		// constructTree(r);
		// BinaryTree<String> myTree2 = new BinaryTree<>(r);
		System.out.println("-----AllPath------");
		// myTree2.preOrder(r, (x) -> System.out.println(x));
		Stack<BinaryTreeNode<String>> st = new Stack<BinaryTreeNode<String>>();
		printAllPathToLeaf(root, st);

		System.out.println("################");
		myTree.visitAllNodesWithBFS(root, (x) -> System.out.println(x));
		System.out.println("################");
		myTree.zigZagTry(root, (x) -> System.out.println(x), true);

	}

	static void printAllPathToLeaf(BinaryTreeNode<String> root, Stack<BinaryTreeNode<String>> st) {
		if (root == null) {
			return;
		}
		st.push(root);
		if (root.isLeaf()) {
			System.out.println("---------");
			for (BinaryTreeNode<String> binaryTreeNode : st) {
				System.out.println(binaryTreeNode.getInfo());
			}
			System.out.println("---------");
		}

		printAllPathToLeaf(root.getLeftChild(), st);
		printAllPathToLeaf(root.getRightChild(), st);
		st.pop();
	}

	static String[] elems = { "Root", "L1", "L2", "R2", "R1" };
	static String[] isLeaf = { "N", "N", "L", "L", "L" };
	static int index = 0;

	private static void constructTree(BinaryTreeNode<String> currentNode) {
		// Root, Left, Right PreOrder
		if (index > elems.length) {
			return;
		}
		if (currentNode != null) {
			int origIndex = index;
			String leftData = elems[index++];
			// String rightData = elems[index++];
			boolean isLeafNode = isLeaf[origIndex].equals("L") ? true : false;
			// boolean isRightChildLeaf = isLeaf[origIndex + 1].equals("L") ? true : false;
			BinaryTreeNode<String> dataNode = new BinaryTreeNode<String>(leftData);
			// BinaryTreeNode<String> r = new BinaryTreeNode<String>(rightData);

			if (currentNode.leftChild == null) {
				currentNode.leftChild = dataNode;
			}
			if (!isLeafNode) {
				constructTree(currentNode.leftChild);
			}
			if (currentNode.rightChild == null) {
				currentNode.rightChild = dataNode;
			}
			if (!isLeafNode) {
				constructTree(currentNode.rightChild);
			}

			// currentNode.setLeftChild(l);

		} else
			return;
	}

}
