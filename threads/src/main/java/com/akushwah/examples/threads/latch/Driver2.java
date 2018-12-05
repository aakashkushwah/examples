package com.akushwah.examples.threads.latch;

import java.util.concurrent.CountDownLatch;

public class Driver2 {
	private static final int N = 5;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = null;
		int j = 0;
		while (j < 4) {
			doneSignal = new CountDownLatch(N);
			for (int i = 0; i < N; ++i) {
				new Thread(new Worker2(doneSignal, i)).start();
			}

			doneSignal.await();
			System.out.println("All workers are done " + j);
			j++;
		}
		System.out.println("aakash");
	}
}
