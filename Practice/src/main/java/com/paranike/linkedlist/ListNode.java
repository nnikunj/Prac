package com.paranike.linkedlist;

public class ListNode<T> {
	private T info;
	private ListNode<T> next;

	// creating leaf node
	public ListNode(T info) {
		this.info = info;
		this.next = null;

	}

	public boolean isLastNode() {
		return (this.next == null) ? true : false;
	}

	public ListNode(T info, ListNode<T> next) {
		this.info = info;
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListNode [info=");
		builder.append(info);
		builder.append(", next=");
		builder.append((next == null) ? null : next.getInfo());
		builder.append("]");
		return builder.toString();
	}

}
