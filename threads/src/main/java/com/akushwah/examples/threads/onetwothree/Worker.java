package com.akushwah.examples.threads.onetwothree;

public class Worker implements Runnable {
	private int value;
	private final Printer p;
	private final int initialVal;

	public Worker(int initialVal, Printer p) {
		this.initialVal = initialVal;
		this.value = initialVal;
		this.p = p;
	}

	@Override
	public void run() {

		synchronized (p) {
			while (true) {
				if (value > App.MAX)
					break;
				switch (initialVal) {
				case 1:
					while (!p.isThreeNPrinted()) {
						try {
							p.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					p.setOneNPrinted(true);
					p.setTwoNPrinted(false);
					p.setThreeNPrinted(false);
					break;
				case 2:
					while (!p.isOneNPrinted()) {
						try {
							p.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					p.setOneNPrinted(false);
					p.setTwoNPrinted(true);
					p.setThreeNPrinted(false);
					break;
				case 3:
					while (!p.isTwoNPrinted()) {
						try {
							p.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					p.setOneNPrinted(false);
					p.setTwoNPrinted(false);
					p.setThreeNPrinted(true);
					break;

				default:
					break;
				}

				p.print(value, initialVal);
				value += 3;
				p.notifyAll();
			}
		}

	}
}
