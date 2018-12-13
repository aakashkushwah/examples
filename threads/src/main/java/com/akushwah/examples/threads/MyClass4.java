package com.akushwah.examples.threads;

public class MyClass4 extends Thread {
	
	public static void main(String[] args) {
		MyClass4 class4 = new MyClass4();
		class4.start();
		
//		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Yo");
	}
	
	public void start() {
		System.out.println("Go");
	}
}
