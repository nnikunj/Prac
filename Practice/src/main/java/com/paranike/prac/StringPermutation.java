package com.paranike.prac;

public class StringPermutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "AB";
		permutationOfString("", str);

		// System.out.println(str.substring(1, str.length()));
		// System.out.println(str.charAt(str.length() - 1));
		System.out.println(c);
	}

	static int c = 0;

	private static void permutationOfString(String prefix, String str) {

		if (str.length() == 0) {
			c++;
			System.out.println(prefix);
		}

		for (int i = 0; i < str.length(); i++) {
			char prefix1 = str.charAt(i);
			permutationOfString(prefix + prefix1, str.substring(0, i) + str.substring(i + 1));
		}

	}
}
