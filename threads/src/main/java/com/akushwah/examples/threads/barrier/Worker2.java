package com.akushwah.examples.threads.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker2 implements Runnable {
	private final CyclicBarrier doneSignal;
	private final String i;

	Worker2(CyclicBarrier doneSignal, String i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		doWork(i);
		try {
			if(doneSignal.getNumberWaiting() == 0) {
				System.out.println("No one is waiting "+i);
			}
			doneSignal.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	void doWork(String i) {
		System.out.println("in worker " + i);
	}
}
