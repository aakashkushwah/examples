package com.akushwah.java8.examples;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> list;
	
	public Stack() {
		list = new LinkedList<>();
	}

	public void push(T t) {
		list.addFirst(t);
	}
	
	public T pop() {
		return list.removeFirst();
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("Aakash");
		stack.push("Joker");
		stack.push("Singh");
		stack.push("Pagal");
		stack.push("Hai");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
