package com.akushwah.examples.threads.latch;

public class Driver3 {
	public static void main(String[] args) throws InterruptedException {
		BooleanLatch doneSignal = new BooleanLatch();
		new Thread(new Worker3(doneSignal, 1)).start();
		doneSignal.await();
		System.out.println("Worker3 done ");
	}
}
