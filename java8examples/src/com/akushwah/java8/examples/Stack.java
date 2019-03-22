package com.akushwah.java8.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
		
		String abc = null;
		System.out.println(Boolean.parseBoolean(Optional.ofNullable(abc).orElse("FALSE")));
		abc="true";
		System.out.println(Boolean.parseBoolean(Optional.ofNullable(abc).orElse("FALSE")));
		
	}
}
