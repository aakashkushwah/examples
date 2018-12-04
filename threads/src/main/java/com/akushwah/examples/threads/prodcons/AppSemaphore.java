package com.akushwah.examples.threads.prodcons;

import java.util.concurrent.Semaphore;

public class AppSemaphore {
	public static void main(String[] args) {
		Semaphore getSem = new Semaphore(0);
		Semaphore setSem = new Semaphore(1);
		
		QueueSemaphore qs = new QueueSemaphore(getSem, setSem);
		new Thread(new ProducerSemaphore(qs)).start();
		new Thread(new ConsumerSemaphore(qs)).start();
	}
}
