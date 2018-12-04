package com.akushwah.examples.threads.prodcons;

public class ProducerSemaphore implements Runnable {

	private QueueSemaphore qs;
	
	public ProducerSemaphore(QueueSemaphore qs) {
		this.qs = qs;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			qs.put("i "+i);
		}		
	}

}
