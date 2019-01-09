package com.paranike.common.bits;

public class BitToggler {

	public int getToggledBits(int n) {
		String s;
		return n ^ Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		BitToggler toggler = new BitToggler();

		int input = 2;
		System.out.println(Integer.toBinaryString(input));

		input = toggler.getToggledBits(input);
		System.out.println(Integer.toBinaryString(input) + " xxxx " + input);

		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		// System.out.println(Integer.parseInt("11111111111111111111111111111111", 2));

	}
}
