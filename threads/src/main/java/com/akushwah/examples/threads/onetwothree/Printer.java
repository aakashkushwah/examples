package com.akushwah.examples.threads.onetwothree;

public class Printer {
	private boolean oneNPrinted;
	private boolean twoNPrinted;
	private boolean threeNPrinted;

	public void print(int n, int threadNumber) {
		System.out.println("T" + threadNumber + " " + n);
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
