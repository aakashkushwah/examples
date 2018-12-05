package com.akushwah.examples.threads.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;

	class Worker implements Runnable {
		int myRow;

		Worker(int row) {
			myRow = row;
		}

		public void run() {
			boolean done = false;
			while (!done) {
				processRow();
				try {
					int client = barrier.await();
					System.out.println("Barrier Await from "+client);
				} catch (InterruptedException ex) {
					System.out.println("InterruptedException in run "+ex);
				} catch (BrokenBarrierException ex) {
					System.out.println("BrokenBarrierException "+ex);
				}
				
				done = true;
				System.out.println("Processing of row: "+myRow+" done.");
			}
		}
		
		private void processRow() {
			try {
				Thread.sleep(1000);
				System.out.println("Processing Row: "+myRow);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException in process "+e);
				e.printStackTrace();
			}
		}
	}

	public Solver(float[][] matrix) throws InterruptedException {
		data = matrix;
		N = matrix.length;
		Runnable barrierAction = new Runnable() {
			public void run() {
				mergeRows();
			}
		};
		barrier = new CyclicBarrier(N, barrierAction);

		List<Thread> threads = new ArrayList<Thread>(N);
		for (int i = 0; i <= N; i++) {
			Thread thread = new Thread(new Worker(i));
			threads.add(thread);
			thread.start();
		}

		// wait until done
		for (Thread thread : threads)
			thread.join();
		System.out.println("Threads are joined");
	}

	private void mergeRows() {
		System.out.println("merging Rows");
	}
	
	public static void main(String[] args) throws InterruptedException {
		float[][] matrix = {{1,2},{3,4},{5,6}};
		new Solver(matrix);
	}
}
