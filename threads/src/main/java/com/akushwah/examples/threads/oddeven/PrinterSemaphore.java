package com.akushwah.examples.threads.oddeven;

import java.util.concurrent.Semaphore;

public class PrinterSemaphore {

	private Semaphore oddSem;
	private Semaphore evenSem;

	public PrinterSemaphore(Semaphore oddSem, Semaphore evenSem) {
		this.oddSem = oddSem;
		this.evenSem = evenSem;
	}

	public void print(int i) {
		if (i % 2 == 0) {
			printEven(i);
		} else {
			printOdd(i);
		}
	}

	private void printOdd(int i) {
		try {
			oddSem.acquire();
		} catch (InterruptedException e) {
			System.err.println("in odd");
			e.printStackTrace();
		}
		System.out.println("Printing Odd " + i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		evenSem.release();
	}

	private void printEven(int i) {
		try {
			evenSem.acquire();
		} catch (InterruptedException e) {
			System.err.println("in even");
			e.printStackTrace();
		}
		System.out.println("Printing Even " + i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		oddSem.release();
	}
}
