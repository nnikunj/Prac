package com.paranike.linkedlist;

import com.paranike.common.NodeInfoProcessor;

public class SinglyLinkedList<T> {
	private ListNode<T> head;

	public SinglyLinkedList() {
		this.head = null;
	}

	public SinglyLinkedList(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> addFirst(T data) {
		ListNode<T> node = new ListNode<T>(data, head);
		this.head = node;
		return head;
	}

	public ListNode<T> addLast(T data) {
		ListNode<T> node = new ListNode<T>(data);

		ListNode<T> current = new ListNode<>(head.getInfo(), head.getNext());
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
		return head;
	}

	public ListNode<T> getMidNode() {
		ListNode<T> current = head;
		if (head == null) {
			return null;
		}

		ListNode<T> fast = head;
		ListNode<T> mid = null;
		while (current != null) {
			mid = fast;
			fast = fast.getNext();
			// Jump twice
			current = current.getNext();
			if (current != null) {
				current = current.getNext();
			}
		}
		return mid;

	}

	public ListNode<T> getReversedList(ListNode<T> head) {
		if (head == null) {
			return null;
		}
		ListNode<T> revHead = null;
		ListNode<T> current = head;
		while (current != null) {
			ListNode<T> elem = new ListNode<T>(current.getInfo());
			elem.setNext(revHead);
			revHead = elem;

			current = current.getNext();
		}
		return revHead;
	}

	public ListNode<T> getReversedListWithRecusrsion(ListNode<T> head) {
		if (head == null) {
			return null;
		}
		ListNode<T> revHead = null;
		// Only One element
		if (head.getNext() == null) {
			revHead = head;
			return revHead;
		} else {
			ListNode<T> node = getReversedListWithRecusrsion(head.getNext());
			node.setNext(head);
			head.setNext(null);
		}
		return revHead;
	}

	public void visitAllNodes(ListNode<T> head, NodeInfoProcessor<T> processor) {
		ListNode<T> current = head;
		while (current != null) {
			processor.processNode(current.getInfo());
			current = current.getNext();
		}
	}
}
