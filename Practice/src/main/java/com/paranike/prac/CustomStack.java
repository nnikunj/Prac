package com.paranike.prac;

public class CustomStack {
	private int[] holder = new int[5];
	int top1;
	int top2;
	// int demarcation;

	public CustomStack() {
		top1 = 0;

		top2 = holder.length - 1;
	}

	public void push1(int item) {
		if (top1 + 1 == top2 || top1 == holder.length - 1) {
			// throw new RuntimeException("Stack 1 is full...");
			System.out.println("Stack 1 is full");
			return;
		}
		holder[top1++] = item;

	}

	public void printStack() {
		System.out.println("---------");
		for (int i : holder) {
			System.out.println(i);
		}
	}

	public void push2(int item) {
		if (top2 < top1 || top2 == 0) {

			System.out.println("Stack 2 is full");
			return;

			// throw new RuntimeException("Stack 2 is full...");
		}

		holder[top2--] = item;
	}

	public int pop1() {
		return holder[top1--];
	}

	public int pop2() {
		return holder[top2++];
	}

	public static void main(String[] args) {
		CustomStack st = new CustomStack();
		st.push1(1);
		st.push1(2);
		st.push1(3);
		st.push2(1);
		st.push2(2);
		st.push2(3);

		st.printStack();
	}
}
