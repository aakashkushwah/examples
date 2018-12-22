package com.akushwah.java8.examples;

import java.util.LinkedHashSet;
import java.util.function.Function;

public class PractticeTest1 {
	
	public static void main(String[] args) {
		LinkedHashSet set = new LinkedHashSet();
		set.add("1");
		set.add(1);
		set.add(2);
		System.out.println(set);
		System.out.println(assign(1, x->x+1));
		System.out.println(assign("a", x->x+'b'));
		
		String s1 = "abc";
		String s2 = s1;
		s1+="d";
		System.out.println(s1+" "+s2+" "+(s1==s2));
		
		StringBuffer s1b = new StringBuffer("abc");
		StringBuffer s2b = s1b;
		s1b.append("d");
		System.out.println(s1b+" "+s2b+" "+(s1b==s2b));
		
		print(null);
		print(1);
		
		int s = 010;
		short x = 010;
		
		
		System.out.println(s);
		System.out.println(x);
		System.out.println();
	}
	
	public static void print(String s) {
		System.out.println("String");
	}
	
	public static void print(Object s) {
		System.out.println("Object");
	}
	
	
	public static <T,R> R assign(T r, Function<T, R> f) {
		return f.apply(r);
	}
}
