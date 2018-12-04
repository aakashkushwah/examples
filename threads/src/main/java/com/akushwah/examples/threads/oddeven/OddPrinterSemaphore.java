package com.akushwah.examples.threads.oddeven;

public class OddPrinterSemaphore implements Runnable {
	private PrinterSemaphore qs;

	public OddPrinterSemaphore(PrinterSemaphore qs) {
		this.qs = qs;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10;i=i+2) {
			qs.print(i);
		}
	}
}
