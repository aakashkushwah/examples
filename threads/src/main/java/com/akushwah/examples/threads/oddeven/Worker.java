package com.akushwah.examples.threads.oddeven;

public class Worker implements Runnable {

	private Printer p;
	private int n;
	private boolean isOddWorker;
	private final int MAX;

	public Worker(Printer p, boolean isOddWorker, int max) {
		this.p = p;
		this.isOddWorker = isOddWorker;
		if (isOddWorker) {
			n = 1;
		} else {
			n = 2;
		}
		this.MAX = max;
	}

	@Override
	public void run() {
		while (n <= MAX) {
			synchronized (p) {
				if (isOddWorker) {
					if (p.isOddPrinted()) {
						try {
							p.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					p.setOddPrinted(true);
				} else {
					if (!p.isOddPrinted()) {
						try {
							p.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					p.setOddPrinted(false);
				}

				p.print(n);
				n = n + 2;
				p.notify();
			}
		}
	}

}
