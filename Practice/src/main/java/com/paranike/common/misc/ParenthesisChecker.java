package com.paranike.common.misc;

import java.util.Stack;

public class ParenthesisChecker {

	public boolean isExpressionBalanced(String expr) {
		boolean isValid = false;
		if (expr == null || expr.isEmpty()) {
			return isValid;
		}
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char current = expr.charAt(i);
			if (current == '(' || current == '{' || current == '[') {
				st.push(current);
			} else if (current == ')') {
				char lastIn = st.pop();
				if (lastIn != '(')
					return isValid;
			} else if (current == '}') {
				char lastIn = st.pop();
				if (lastIn != '{')
					return isValid;
			} else if (current == ']') {
				char lastIn = st.pop();
				if (lastIn != '[')
					return isValid;
			} else {
				continue;
			}
		}
		if (st.isEmpty()) {
			isValid = true;
		}
		return isValid;
	}

	public static void main(String[] args) {
		ParenthesisChecker checker = new ParenthesisChecker();
		String s = "[(A+b)*{k}]";
		System.out.println(checker.isExpressionBalanced(s));
	}

}
