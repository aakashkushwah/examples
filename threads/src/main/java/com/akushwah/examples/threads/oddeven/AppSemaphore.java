package com.akushwah.examples.threads.oddeven;

import java.util.concurrent.Semaphore;

public class AppSemaphore {
	public static void main(String[] args) {
		Semaphore oddSem = new Semaphore(1);
		Semaphore evenSem = new Semaphore(0);
		
		PrinterSemaphore qs = new PrinterSemaphore(oddSem, evenSem);
		new Thread(new EvenPrinterSemaphore(qs)).start();
		new Thread(new OddPrinterSemaphore(qs)).start();
	}
}
