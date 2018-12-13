package com.akushwah.examples.threads;

public class MyClass1 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				synchronized (String.class) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("1");
					synchronized (Object.class) {
						System.out.println("2");
					}
				}
				System.out.println("3");
			}
		}, "Thread-1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				synchronized (Object.class) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("4");
					synchronized (String.class) {
						System.out.println("5");
					}
				}
				System.out.println("6");
			}
		}, "Thread-2");

		t1.start();
		t2.start();
	}
}
