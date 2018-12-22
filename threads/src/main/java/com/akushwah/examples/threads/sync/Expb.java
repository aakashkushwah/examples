package com.akushwah.examples.threads.sync;

public class Expb extends Expa{
	static int x = 20;
	
	public static void main(String[] args) {
		Expa a = new Expa();
		Expa b = new Expb();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
//				a.add1();
//				a.add3();
				a.add5();
//				b.add6();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
//				a.add2();
				a.add4();
//				a.add6();
//				b.add3();
			}
		});
		
		t1.start();
		t2.start();
	}
}
