package com.akushwah.examples.threads.oddeven;

public class App {

	public static final int MAX = 100;

	public static void main(String[] args) {

		Printer p = new Printer(false);
		// Thread t1 = new Thread(new OddWorker(p, 1));
		// Thread t2 = new Thread(new EvenWorker(p, 2));
		// t1.start();
		// t2.start();

		Thread t1 = new Thread(new Worker(p, true, MAX));
		Thread t2 = new Thread(new Worker(p, false, MAX));
		t1.start();
		t2.start();
	}
}
