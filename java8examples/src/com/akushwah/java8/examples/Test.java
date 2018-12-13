package com.akushwah.java8.examples;

public class Test {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + s1 == s2);
//		System.out.println("s1 == s2 is:" + (s1 == s2));

		Test test = new Test();
		System.out.println(test.reverse("Aakash"));
	}

	public String reverse(String input) {
		StringBuilder sb = new StringBuilder();
		char[] characters = input.toCharArray();		
		reverseHelper(characters, sb, 0, input.length());
		return sb.toString();
	}

	private void reverseHelper(char[] characters, StringBuilder sb, int index, int length) {
		if (index > length - 1) {
			return;
		} else {
			char c = characters[length - index - 1];
			sb.append(c);
			reverseHelper(characters, sb, ++index, length);
		}
	}
}
