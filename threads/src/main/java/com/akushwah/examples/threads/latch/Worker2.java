package com.akushwah.examples.threads.latch;

import java.util.concurrent.CountDownLatch;

class Worker2 implements Runnable {
	private final CountDownLatch doneSignal;
	private final int i;

	Worker2(CountDownLatch doneSignal, int i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		doWork(i);
		doneSignal.countDown();
	}

	void doWork(int i) {
		System.out.println("in worker " + i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
