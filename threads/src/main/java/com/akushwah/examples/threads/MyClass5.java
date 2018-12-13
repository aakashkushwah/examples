package com.akushwah.examples.threads;

public class MyClass5 {
	public static void main(String[] args) {
		System.out.println("1");
		InnerClass i = new InnerClass();
		i.start();
		System.out.println("2");
	}
	
	static class InnerClass extends Thread{
		@Override
		public void run() throws RuntimeException{
			// TODO Auto-generated method stub
			throw new RuntimeException();
		}
	}
}
