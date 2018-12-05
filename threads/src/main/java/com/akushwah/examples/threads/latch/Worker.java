package com.akushwah.examples.threads.latch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	private final int i;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal, int i) {
		this.startSignal = startSignal;
		this.i = i;
		this.doneSignal = doneSignal;
	}

	@Override
	public void run() {
		try {
			startSignal.await();
			doWork(i);
			doneSignal.countDown();
		} catch (InterruptedException e) {
			System.out.println("i="+i);
			e.printStackTrace();
		}
		

	}

	void doWork(int i) throws InterruptedException {
		System.out.println("in worker " + i);
		Thread.sleep(3000);
	}

}
