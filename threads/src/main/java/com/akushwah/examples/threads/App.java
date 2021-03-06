package com.akushwah.examples.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ThreadPool pool = new ThreadPool(3);

		for (int i = 0; i < 5; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 5; i < 10; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new Task(11));
		executor.shutdown();
		
	}
}
