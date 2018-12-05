package com.akushwah.examples.threads.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Driver {
	private static final int N = 5;
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);
		
		List<Thread> list = new ArrayList<>();
		for (int i = 0; i < N; ++i) { // create and start threads
			Runnable runnable = new Worker(startSignal, doneSignal, i);
			Thread thread = new Thread(runnable);
			list.add(thread);
			thread.start();
		}
		
		
		System.out.println("1");
		doSomethingElse(); // don't let run yet
		System.out.println("2");
		startSignal.countDown(); // let all threads proceed
		
//		list.get(2).interrupt();
		System.out.println("3");
		doSomethingElse();
		System.out.println("4");
		doneSignal.await(); // wait for all to finish
		System.out.println("All finished");
	}
	
	private static void doSomethingElse() {
		try {
			System.out.println("doing something else for 1 second");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
