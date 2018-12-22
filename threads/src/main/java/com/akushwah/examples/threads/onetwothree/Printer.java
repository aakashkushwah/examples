package com.akushwah.examples.threads.onetwothree;

import com.akushwah.examples.threads.onetwothree.App.SEQ;

public class Printer {
	private boolean oneNPrinted;
	private boolean twoNPrinted;
	private boolean threeNPrinted;
	
	public void print(int n, SEQ seq) {
		System.out.println("T"+ (seq.ordinal()+1)+" "+n);
	}
	
	public boolean isOneNPrinted() {
		return oneNPrinted;
	}
	public void setOneNPrinted(boolean oneNPrinted) {
		this.oneNPrinted = oneNPrinted;
	}
	public boolean isTwoNPrinted() {
		return twoNPrinted;
	}
	public void setTwoNPrinted(boolean twoNPrinted) {
		this.twoNPrinted = twoNPrinted;
	}
	public boolean isThreeNPrinted() {
		return threeNPrinted;
	}
	public void setThreeNPrinted(boolean threeNPrinted) {
		this.threeNPrinted = threeNPrinted;
	}
	
	
}
