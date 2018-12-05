package com.akushwah.examples.threads.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Driver2 {
	private static final int N = 5;

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier doneSignal = new CyclicBarrier(N);
		int j = 0;
		while (j < 4) {
			List<Thread> threads = new ArrayList<Thread>(N);
			for (int i = 0; i < N; i++) {
				Thread thread = new Thread(new Worker2(doneSignal, ""+j+i));
				threads.add(thread);
				thread.start();
			}
			for (Thread thread : threads)
				thread.join();
			doneSignal.reset();
			System.out.println("All workers are done " + j);
			j++;
		}
	}
}
