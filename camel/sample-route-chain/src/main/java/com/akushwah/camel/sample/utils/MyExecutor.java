package com.akushwah.camel.sample.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {
	private static MyExecutor INSTANCE = null;
	private ExecutorService executor = null;
	private MyExecutor() {
		executor = Executors.newFixedThreadPool(5);
	}
	
	public static MyExecutor getInstance() {
		if(INSTANCE == null) {
			synchronized(MyExecutor.class) {
				if(INSTANCE == null) {
					INSTANCE = new MyExecutor();
				}
			}
		}
		return INSTANCE;
	}
	
	public void execute(WorkerThread<?> worker) {
		executor.execute(worker);
	}
	
	
}
