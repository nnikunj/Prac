package com.paranike.common.bits;

public class BalancedParenthesisWithSmileys {
	public boolean isBalanced(String input) {
		int i = -1;

		// First check if there non-allowed characters, not using length knowingly
		try {
			while (true) {
				i++;
				Character c = input.charAt(i);
				if (c < 'a' || c > 'z') {
					if (c != ':' && c != ' ' && c != '(' && c != ')')
						return false;
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Reached @ the end of the string");
		}
		// S for Sad emoticon H for happy emoticon */
		input = input.replace(":(", "S");// Sad
		input = input.replace(":)", "H");// Happy

		// Keep only (, ), S and H, replace everything else by empty string */
		input = input.replaceAll("[a-z :]", "");
		System.out.println("Converted Input Str =" + input);

		return isBalancesPerenthesis(input);
	}

	private boolean isBalancesPerenthesis(String input) {
		boolean isBalancedFromLeft = isBalancesPerenthesisFromLeft(input);
		boolean isBalancedFromRight = isBalancesPerenthesisFromRight(input);
		return isBalancedFromLeft && isBalancedFromRight;
	}

	// It only considers sad count, openCount and closedCount */
	private boolean isBalancesPerenthesisFromLeft(String input) {
		int openCount = 0;
		int closedCount = 0;
		int sadCount = 0;
		int happyCount = 0;

		for (Character c : input.toCharArray()) {
			if (c == '(') {
				openCount++;
			} else if (c == ')') {
				closedCount++;
				if (openCount + sadCount - closedCount < 0) {
					return false;
				}
			} else if (c == 'S') {
				sadCount++;
			} else if (c == 'H') {
				happyCount++;
			}
		}
		return true;
	}

	// It only considers happy count, openCount and closedCount */
	private boolean isBalancesPerenthesisFromRight(String input) {
		int openCount = 0;
		int closedCount = 0;
		int sadCount = 0;
		int happyCount = 0;

		for (int i = input.length() - 1; i >= 0; i--) {
			Character c = input.charAt(i);
			if (c == '(') {
				openCount++;
				if (closedCount + happyCount - openCount < 0) {
					return false;
				}
			} else if (c == ')') {
				closedCount++;
			} else if (c == 'S') {
				sadCount++;
			} else if (c == 'H') {
				happyCount++;
			}
		}
		return true;
	}
}