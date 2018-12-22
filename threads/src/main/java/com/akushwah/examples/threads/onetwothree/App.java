package com.akushwah.examples.threads.onetwothree;

public class App {
	public enum SEQ {N1, N2, N3};
	public static final int MAX=20;
	
	public static void main(String[] args) {
		Printer p = new Printer();
		p.setOneNPrinted(false);
		p.setTwoNPrinted(true);
		p.setThreeNPrinted(true);
		new Thread(new Worker(1, p)).start();
		new Thread(new Worker(2, p)).start();
		new Thread(new Worker(3, p)).start();
	}
}
