package com.akushwah.examples.threads.semaphor;

public class EvenPrinterSemaphore implements Runnable {

	private PrinterSemaphore qs;
	
	public EvenPrinterSemaphore(PrinterSemaphore qs) {
		this.qs = qs;
	}
	
	@Override
	public void run() {
		for (int i = 2; i <= 10;i=i+2) {
			qs.print(i);
		}		
	}

}
