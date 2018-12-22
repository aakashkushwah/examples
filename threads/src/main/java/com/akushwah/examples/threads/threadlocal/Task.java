package com.akushwah.examples.threads.threadlocal;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private ThreadLocal<LocalDateTime> startDate = new ThreadLocal<LocalDateTime>() {
		@Override
		protected LocalDateTime initialValue() {
			return LocalDateTime.now();
		}
	};

	@Override
	public void run() {
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
		
		
	}

}
