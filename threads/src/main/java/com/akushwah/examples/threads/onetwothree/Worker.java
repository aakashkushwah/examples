package com.akushwah.examples.threads.onetwothree;

import com.akushwah.examples.threads.onetwothree.App.SEQ;

public class Worker implements Runnable {
	private int value;
	private final Printer p;
	private SEQ seq;

	public Worker(int initialVal, Printer p) {
		this.value = initialVal;
		this.p = p;
		switch (initialVal) {
		case 1:
			seq = SEQ.N1;
			break;
		case 2:
			seq = SEQ.N2;
			break;
		case 3:
			seq = SEQ.N3;
			break;
		default:
			break;
		}
	}

	@Override
	public void run() {

		synchronized (p) {
			while (true) {
				if (value > App.MAX)
					break;
				switch (seq) {
				case N1:
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
				case N2:
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
				case N3:
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

				p.print(value, seq);
				value += 3;
				p.notifyAll();
			}
		}

	}
}
