package com.paranike.common.trees;

public class LowestCommonAncestor {

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

		LowestCommonAncestor obj = new LowestCommonAncestor();
		BinaryTreeNode<String> common = obj.getLowestCA(root, r2, r1);
		System.out.println(common.getInfo());

	}

	public BinaryTreeNode<String> getLowestCA(BinaryTreeNode<String> root, BinaryTreeNode<String> n1,
			BinaryTreeNode<String> n2) {

		if (root == null)
			return null;
		if ((root.getInfo().equals(n1.getInfo())) || (root.getInfo().equals(n2.getInfo()))) {
			return root;
		}
		BinaryTreeNode<String> ancestorLeftWing = getLowestCA(root.getLeftChild(), n1, n2);
		BinaryTreeNode<String> ancestorRightWing = getLowestCA(root.getRightChild(), n1, n2);
		if (ancestorLeftWing == null && ancestorRightWing == null) {
			return null;
		}
		if (ancestorLeftWing != null && ancestorRightWing != null) {
			// Parent of both
			return root;
		}

		return (ancestorLeftWing != null) ? ancestorLeftWing : ancestorRightWing;

	}
}
