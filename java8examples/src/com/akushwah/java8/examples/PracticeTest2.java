package com.akushwah.java8.examples;

import java.util.EnumSet;

public class PracticeTest2 {
	public static void main(String[] args) {
		C1 c1 = new C1();
		
		Thread t1 = new Thread(new Two(),"print3");
		t1.start();
		
	}
}

class One implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}

class Two implements Runnable{

	@Override
	public void run() {
		new One().run();
		new Thread(new One(), "print1").run();
		new Thread(new One(), "print2").start();
	}
	
}

class A1{
	String s = "classA";
}

class B1 extends A1{
	String s ="classB";
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
