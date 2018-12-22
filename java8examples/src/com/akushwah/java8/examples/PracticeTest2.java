package com.akushwah.java8.examples;

import java.util.LinkedList;

public class PracticeTest2 {
	public static void main(String[] args) {
//		C1 c1 = new C1();
//
//		Thread t1 = new Thread(new Two(), "print3");
//		t1.start();
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.add(1);
		l1.add(4);
		l1.add(8);
		l1.add(1);
		printLinkedList(l1);
		LinkedList<Integer> l2 = new LinkedList<>();
		l2.add(8);
		l2.add(4);
		l2.add(6);
		printLinkedList(l2);
		printLinkedList(add(l1, l2));
		
	}
	
	private static LinkedList<Integer> add(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> result = new LinkedList<>();
		LinkedList<Integer> bl = null;
		LinkedList<Integer> sl = null;
		if(l1.size() == Math.max(l1.size(), l2.size())) {
			bl=l1;
			sl=l2;
		}else {
			bl=l2;
			sl=l1;
		}
		int carry = 0;
		while(!bl.isEmpty()) {
			int a = bl.remove();
			int b = 0;
			if(!sl.isEmpty()) {
				b=sl.remove();
			}
			int sum = a+b+carry;
			carry = sum/10;
			int item = sum%10;
			result.add(item);
		}
		if(carry!=0) {
			result.add(carry);
		}
		return result;
	}
	
	private static void printLinkedList(LinkedList<Integer> list) {
		LinkedList<Integer> l1 = (LinkedList<Integer>)list.clone();
		StringBuffer buffer = new StringBuffer();
		while(!l1.isEmpty()) {
			buffer.append(l1.remove());
			buffer.append(">-");
		}
		buffer.append("dne");
		System.out.println(buffer.reverse());
	}

}



	class One implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}

	}

	class Two implements Runnable {

		@Override
		public void run() {
			new One().run();
			new Thread(new One(), "print1").run();
			new Thread(new One(), "print2").start();
		}

	}

	class A1 {
		String s = "classA";
	}

	class B1 extends A1 {
		String s = "classB";
		{
			System.out.println(super.s);
		}
	}

class C1 extends B1{
	String s ="classC";
	{
		System.out.println(super.s);
	}
}
