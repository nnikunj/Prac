package com.paranike.common.bits;

public class BitToggler {

	public int getToggledBits(int n) {

		return n ^ Integer.MAX_VALUE;
	}

	public int bitToggler(int n) {
		if (n == 0) {
			return 1;
		}
		int sol = 0;
		int nextSetBit = 1;
		while (n != 0) {
			int lastBit = n & 1;
			if (lastBit == 0) {
				sol = sol | nextSetBit;
			}
			nextSetBit <<= 1;
			n >>>= 1;

		}
		return sol;
	}

	public static void main(String[] args) {
		BitToggler toggler = new BitToggler();

		int input = 2;
		System.out.println(Integer.toBinaryString(input));

		input = toggler.getToggledBits(input);
		System.out.println(Integer.toBinaryString(input) + " xxxx " + input);

		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		int in2 = 5;
		System.out.println(Integer.toBinaryString(in2));
		int s = toggler.bitToggler(in2);
		System.out.println(Integer.toBinaryString(s));

	}
}
