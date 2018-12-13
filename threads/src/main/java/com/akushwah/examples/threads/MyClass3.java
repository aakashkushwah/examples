package com.akushwah.examples.threads;

class Class2{
	void method2(String name) {
		for (int i = 1; i <= 2; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
public class MyClass3 implements Runnable{
	Class2 obj2;
	
	public static void main(String[] args) {
		new MyClass3().method1();
	}
	
	void method1() {
		obj2 = new Class2();
		new Thread(new MyClass3()).start();
		new Thread(new MyClass3()).start();
	}
	
	public void run() {
		obj2.method2(Thread.currentThread().getName());
	}
}
