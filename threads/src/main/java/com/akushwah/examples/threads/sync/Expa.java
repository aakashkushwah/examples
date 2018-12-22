package com.akushwah.examples.threads.sync;

public class Expa {

	static int x = 10;
	void add1() {
		System.out.println("Inside add1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Existing add1");
	}
	
	void add2() {
		System.out.println("Inside add2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Existing add2");
	}
	
	synchronized void add3() {
		System.out.println("Inside add3");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Existing add3");
	}
	
	synchronized void add4() {
		System.out.println("Inside add4");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Existing add4");
	}
	
	static synchronized void add5() {
		System.out.println("Inside add5");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Existing add5");
	}
	
	static synchronized void add6() {
		System.out.println("Inside add6");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Existing add6");
	}
}
