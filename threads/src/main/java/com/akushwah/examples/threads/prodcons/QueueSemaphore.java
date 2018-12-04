package com.akushwah.examples.threads.prodcons;

import java.util.concurrent.Semaphore;

public class QueueSemaphore {
	
	private String s;
	
	private Semaphore getSem;
	private Semaphore setSem;
	
	public QueueSemaphore(Semaphore getSem, Semaphore setSem) {
		this.getSem = getSem;
		this.setSem = setSem;
	}
	
	public void put(String s) {
		try {
			setSem.acquire();
		} catch (InterruptedException e) {
			System.err.println("in set");
			e.printStackTrace();
		}
		this.s = s;	
		System.out.println("Producing "+this.s);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getSem.release();
	}
	
	public void get() {
		try {
			getSem.acquire();
		} catch (InterruptedException e) {
			System.err.println("in get");
			e.printStackTrace();
		}
		System.out.println("Consuming "+this.s);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setSem.release();
	}
}
