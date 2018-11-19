package com.akushwah.camel.sample.utils;

import java.util.function.Consumer;

public class WorkerThread<T> implements Runnable {

	private Consumer<T> command;
	private T t;

	public WorkerThread(Consumer<T> consumer, T t) {
		this.command = consumer;
		this.t = t;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand() {
		command.accept(t);
	}

}
