package com.akushwah.java8.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + s1 == s2);
		// System.out.println("s1 == s2 is:" + (s1 == s2));

		Test test = new Test();
		System.out.println(test.reverse("Aakash"));

		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("2", "b");
		map.put("1", "a");
		map.put("3", "c");
		map.put("4", "d");

		map.forEach((a, b) -> {
			System.out.println(a + b);
			if (a.equals("2")) {
				map.remove("3");
			}
		});

		map.keySet().iterator().forEachRemaining(System.out::println);

		List<String> names1 = new ArrayList<>();

		// Add some names to the list
		names1.add("Ken");
		names1.add("Lee");
		names1.add("Joe");
		names1.add("Poe");
		names1.add("Kai");

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					Iterator<String> iterator = names1.iterator();
					while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}

				}
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					Iterator<String> iterator = names1.iterator();
					while (iterator.hasNext()) {
						String ele = iterator.next();
						if (ele.equalsIgnoreCase("Kai")) {
							iterator.remove();
						}
					}
					names1.add("Kai");
				}
			}
		});

		t2.start();
		t1.join();
		t2.join();
		// Print all elements of the names list
		names1.iterator().forEachRemaining(System.out::println);

		SortedSet<Person> set = new TreeSet<>(Comparator.comparing(Person::getName).reversed());
		set.add(new Person("Aakash", 31));
		set.add(new Person("Joker", 30));

		set.forEach(System.out::println);

		SortedSet<String> names = new TreeSet<>();
		names.add("John");
		names.add("Adam");
		names.add("Eve");
		names.add("Donna");

		// Print the sorted set
		System.out.println("Sorted Set: " + names);

		// Print the first and last elements in the sorted set
		System.out.println("First: " + names.first());
		System.out.println("Last: " + names.last());
		SortedSet<String> ssBeforeDonna = names.headSet("Donna");
		System.out.println("Head Set Before Donna: " + ssBeforeDonna);
		SortedSet<String> ssBetwenDonnaAndJohn = names.subSet("Donna", "John");
		System.out.println("Subset between Donna and John (exclusive): " + ssBetwenDonnaAndJohn);
		// Note the trick "John" + "\0" to include "John" in the subset
		SortedSet<String> ssBetwenDonnaAndJohn2 = names.subSet("Donna", "John" + "\0");
		System.out.println("Subset between Donna and John (Inclusive): " + ssBetwenDonnaAndJohn2);
		SortedSet<String> ssDonnaAndAfter = names.tailSet("Donna");
		System.out.println("Subset from Donna onwards: " + ssDonnaAndAfter);

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
