package com.akushwah.examples.threads;

public class Task implements Runnable {

    private int num;

    public Task(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Task " + num + " is running.");
    }
    
    @Override
    public String toString() {
    	return "Task "+num;
    }
}