package com.akushwah.examples.threads;

import com.akushwah.examples.threads.locks.SharedFiFo;

public class ThreadPool {

	private final int numOfThreads;
//	private final BlockingQueue<Runnable> queue;
	private final SharedFiFo<Runnable> queue;
	private final PoolWorker[] threads;

	public ThreadPool(int n) {
		this.numOfThreads = n;
//		queue = new LinkedBlockingQueue<>();
		queue = new SharedFiFo<>(3);
		threads = new PoolWorker[numOfThreads];
		for (int i = 0; i < numOfThreads; i++) {
			threads[i] = new PoolWorker("Thread " + i);
			new Thread(threads[i]).start();
		}

	}

	public void execute(Runnable r) {
		// synchronized (queue) {
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// queue.notify();
		// }
	}
	
	public void shutdown() {
		
	}

	private class PoolWorker implements Runnable {
		private String name;

		public PoolWorker(String name) {
			this.name = name;
		}

		public void run() {
			Runnable r = null;
			while (true) {
				// synchronized (queue) {
				// while (queue.isEmpty()) {
				// try {
				// queue.wait();
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				// }
				// r = queue.poll();

				// }
				try {
					r = queue.take();
					System.out.println("Running from " + name+" and job is "+r);
					Thread.sleep(2000);
					r.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				} catch (InterruptedException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
