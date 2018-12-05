package com.akushwah.examples.threads.latch;

class Worker3 implements Runnable {
	private final BooleanLatch doneSignal;
	private final int i;

	Worker3(BooleanLatch doneSignal, int i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		doWork(i);
		doneSignal.signal();
	}

	void doWork(int i) {
		System.out.println("in worker " + i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
