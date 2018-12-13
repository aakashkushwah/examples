package com.akushwah.examples.threads;

public class MyClass {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable, "thread-1");
		Thread t2 = new Thread(myRunnable, "thread-2");
		t1.start();
		t2.start();
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		method();		
	}
	
	synchronized void method() {
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}
//
//class MyRunnable implements Runnable {
//
//	@Override
//	public void run() {
//		synchronized (this) {
//			System.out.println("1");
//			try {
//				this.wait();
//				System.out.println("2");
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//}
