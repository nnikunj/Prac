package com.paranike.linkedlist;

public class Main {
	public static void main(String[] args) {
		ListNode<String> head = new ListNode<String>("1");
		SinglyLinkedList<String> list = new SinglyLinkedList<>(head);

		head = list.addFirst("0");
		head = list.addFirst("-1");
		head = list.addLast("2");
		head = list.addLast("3");
		list.visitAllNodes(head, (x) -> System.out.println(x));
		ListNode<String> mid = list.getMidNode();
		System.out.println("ZZZZZZZZZ");
		System.out.println(mid.getInfo());
		System.out.println("ZZZZZZZZZ");
		ListNode<String> revHead = list.getReversedList(head);
		System.out.println("ZZZZZZZZZ");
		list.visitAllNodes(revHead, (x) -> System.out.println(x));
		System.out.println("ZZZZZZZZZ");

		ListNode<String> revHead2 = list.getReversedList(revHead);
		list.visitAllNodes(revHead2, (x) -> System.out.println(x));
	}
}
