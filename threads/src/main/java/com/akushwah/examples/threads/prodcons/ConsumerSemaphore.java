package com.akushwah.examples.threads.prodcons;

public class ConsumerSemaphore implements Runnable {
	private QueueSemaphore qs;

	public ConsumerSemaphore(QueueSemaphore qs) {
		this.qs = qs;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			qs.get();
		}
	}
}
