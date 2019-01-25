package com.paranike.common.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeSerialization {

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

		ArrayList<BinaryTreeNode<String>> lst = new ArrayList<>();

		TreeSerialization obj = new TreeSerialization();
		obj.serializeTree(root, lst);
		for (BinaryTreeNode<String> binaryTreeNode : lst) {
			System.out.print("--" + (binaryTreeNode == null ? null : binaryTreeNode.getInfo()));
		}
		BinaryTreeNode<String> againRoot = obj.deSerialize(lst);
		ArrayList<BinaryTreeNode<String>> lst2 = new ArrayList<>();
		obj.serializeTree(againRoot, lst2);
		System.out.println("XX");
		for (BinaryTreeNode<String> binaryTreeNode : lst2) {
			System.out.print("--" + (binaryTreeNode == null ? null : binaryTreeNode.getInfo()));

		}

	}

	// Deserialization Index
	int index = 0;

	public BinaryTreeNode<String> deSerialize(List<BinaryTreeNode<String>> lstRepr) {
		BinaryTreeNode<String> root = null;
		if (index >= lstRepr.size()) {
			return null;
		}
		BinaryTreeNode<String> node = lstRepr.get(index++);
		if (node != null)
			root = new BinaryTreeNode<String>(node.getInfo());
		else {
			// return null
			return root;
		}
		BinaryTreeNode<String> l = deSerialize(lstRepr);
		BinaryTreeNode<String> r = deSerialize(lstRepr);

		root.setLeftChild(l);
		root.setRightChild(r);

		return root;
	}

	public void serializeTree(BinaryTreeNode<String> root, List<BinaryTreeNode<String>> lstRepr) {
		if (root == null) {
			lstRepr.add(null);
			return;
		}
		lstRepr.add(root);
		serializeTree(root.getLeftChild(), lstRepr);
		serializeTree(root.getRightChild(), lstRepr);

	}

}
