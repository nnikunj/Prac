package com.paranike.common.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViewsOfBinaryTree {

	private BinaryTreeNode<String> root;

	public ViewsOfBinaryTree(BinaryTreeNode<String> root) {
		this.root = root;
	}

	public BinaryTreeNode<String> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<String> root) {
		this.root = root;
	}

	private Map<Integer, List<BinaryTreeNode<String>>> getHorizontalDistanceMap() {
		LinkedList<TreeQueueElem> q = new LinkedList<TreeQueueElem>();
		TreeQueueElem elem = new TreeQueueElem(this.root, 0);
		HashMap<Integer, List<BinaryTreeNode<String>>> hdMap = new HashMap<>();

		q.add(elem);
		while (!q.isEmpty()) {
			TreeQueueElem currElem = q.poll();
			int parentHd = currElem.getHorizontalDistance();
			// Add its children
			BinaryTreeNode<String> lChild = currElem.getNode().getLeftChild();
			BinaryTreeNode<String> rChild = currElem.getNode().getRightChild();
			if (lChild != null)
				q.add(new TreeQueueElem(lChild, parentHd - 1));
			if (rChild != null)
				q.add(new TreeQueueElem(rChild, parentHd + 1));
			List<BinaryTreeNode<String>> l = hdMap.get(parentHd);
			if (l == null) {
				l = new ArrayList<>();
				l.add(currElem.getNode());
				hdMap.put(parentHd, l);
			} else {
				l.add(currElem.getNode());
			}
		}
		return hdMap;
	}

	public List<BinaryTreeNode<String>> getTopView() {
		Map<Integer, List<BinaryTreeNode<String>>> hdMap = getHorizontalDistanceMap();
		Set<Integer> keySet = hdMap.keySet();
		ArrayList<Integer> keyLst = new ArrayList<>();
		keyLst.addAll(keySet);
		Collections.sort(keyLst);
		List<BinaryTreeNode<String>> retLst = new ArrayList<>();
		for (Integer k : keyLst) {
			List<BinaryTreeNode<String>> l = hdMap.get(k);
			retLst.add(l.get(0));
		}
		return retLst;
	}

	public List<BinaryTreeNode<String>> getBottomView() {
		Map<Integer, List<BinaryTreeNode<String>>> hdMap = getHorizontalDistanceMap();
		Set<Integer> keySet = hdMap.keySet();
		ArrayList<Integer> keyLst = new ArrayList<>();
		keyLst.addAll(keySet);
		Collections.sort(keyLst);
		List<BinaryTreeNode<String>> retLst = new ArrayList<>();
		for (Integer k : keyLst) {
			List<BinaryTreeNode<String>> l = hdMap.get(k);
			retLst.add(l.get(l.size() - 1));
		}
		return retLst;
	}

	public static void main(String[] args) {
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("a");

		BinaryTreeNode<String> b = new BinaryTreeNode<String>("b");
		BinaryTreeNode<String> c = new BinaryTreeNode<String>("c");
		BinaryTreeNode<String> d = new BinaryTreeNode<String>("d");
		BinaryTreeNode<String> e = new BinaryTreeNode<String>("e");
		BinaryTreeNode<String> f = new BinaryTreeNode<String>("f");
		BinaryTreeNode<String> g = new BinaryTreeNode<String>("g");
		BinaryTreeNode<String> h = new BinaryTreeNode<String>("h");
		BinaryTreeNode<String> i = new BinaryTreeNode<String>("i");
		BinaryTreeNode<String> j = new BinaryTreeNode<String>("j");
		BinaryTreeNode<String> k = new BinaryTreeNode<String>("k");
		BinaryTreeNode<String> l = new BinaryTreeNode<String>("l");

		root.setLeftChild(b);
		root.setRightChild(c);

		b.setLeftChild(d);
		b.setRightChild(e);

		c.setLeftChild(f);
		c.setRightChild(g);

		f.setLeftChild(h);
		f.setRightChild(i);

		d.setLeftChild(l);

		i.setRightChild(j);

		j.setRightChild(k);

		ViewsOfBinaryTree tree = new ViewsOfBinaryTree(root);
		List<BinaryTreeNode<String>> topView = tree.getTopView();
		for (BinaryTreeNode<String> binaryTreeNode : topView) {
			System.out.println(binaryTreeNode.getInfo());
		}
		System.out.println("BottomView");
		List<BinaryTreeNode<String>> bottomView = tree.getBottomView();
		for (BinaryTreeNode<String> binaryTreeNode : bottomView) {
			System.out.println(binaryTreeNode.getInfo());
		}
	}
}

class TreeQueueElem {
	int horizontalDistance;
	BinaryTreeNode<String> node;

	public TreeQueueElem(BinaryTreeNode<String> node, int horizontalDistance) {
		this.horizontalDistance = horizontalDistance;
		this.node = node;
	}

	public int getHorizontalDistance() {
		return horizontalDistance;
	}

	public void setHorizontalDistance(int horizontalDistance) {
		this.horizontalDistance = horizontalDistance;
	}

	public BinaryTreeNode<String> getNode() {
		return node;
	}

	public void setNode(BinaryTreeNode<String> node) {
		this.node = node;
	}

}