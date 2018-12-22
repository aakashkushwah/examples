package com.akushwah.examples.threads.semaphor;

import java.util.concurrent.Semaphore;

public class AppSemaphore {
	public static void main(String[] args) throws InterruptedException {
		Semaphore oddSem = new Semaphore(1);
		Semaphore evenSem = new Semaphore(0);
		
		PrinterSemaphore qs = new PrinterSemaphore(oddSem, evenSem);
		new Thread(new OddPrinterSemaphore(qs)).start();
		new Thread(new EvenPrinterSemaphore(qs)).start();
		
		Semaphore sem1 = new Semaphore(1);
		sem1.acquire();
		System.out.println("1");
		sem1.release();
		
		Semaphore sem2 = new Semaphore(0);
		sem2.acquire();
		System.out.println("2");
		sem2.release();
		
	}
}
