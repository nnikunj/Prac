package com.paranike.common.bits;

public class BitsPrograms {

	public static void main(String[] args) {
		int i = 2;
		System.out.println("Initial string " + Integer.toBinaryString(i));
		int j = i << 2;
		System.out.println("Left shift 2 bits string " + Integer.toBinaryString(j));

		int k = i >>> 2;
		System.out.println("Right shift 2 bits keeping sign bit intact  string " + Integer.toBinaryString(k));

		System.out.println(Integer.toBinaryString((i << 2) | (i >>> Integer.SIZE - 2)));

		int a = 5;
		int b = 2;
		System.out.println("Initila a: " + a);
		System.out.println("Initila b: " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("later a: " + a);
		System.out.println("later b: " + b);
		a = 2;

		System.out.println("----------");
		System.out.println(Integer.toBinaryString(a));
		// a = a ^ 3;
		System.out.println(Integer.toBinaryString(a ^ 3));

	}

}
