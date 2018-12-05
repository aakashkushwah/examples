package com.akushwah.examples.threads.barrier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Main {
	CyclicBarrier barrier;

	List<Result> results = new ArrayList<Result>();

	static long timeConnect(String site) {
		long start = System.currentTimeMillis();
		try {
			System.out.println("Connecting "+site);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			return -1;
		}
		return System.currentTimeMillis() - start;
	}

	void showResults() {
		Collections.sort(results);
		for (Result result : results)
			System.out.printf("%-30.30s : %d\n", result.site, result.time);
		System.out.println("------------------");
	}

	public void start(String[] args) {
		Runnable showResultsAction = new Runnable() {
			public void run() {
				showResults();
				results.clear();
			}
		};
		barrier = new CyclicBarrier(args.length, showResultsAction);

		for (final String site : args)
			new Thread() {
				public void run() {
					int i = 0;
					while (i < 5) {
						long time = timeConnect(site);
						results.add(new Result(time, site));
						try {
							barrier.await(99, TimeUnit.SECONDS);
							barrier.reset();
						} catch (BrokenBarrierException e) {
							return;
						} catch (Exception e) {
							return;
						}
						i++;
					}
				}
			}.start();
	}

	public static void main(String[] args) throws IOException {

		new Main().start(new String[] { "www.java2s.com", "www.google.com" });
	}
}

class Result implements Comparable<Result> {
	Long time;

	String site;

	Result(Long time, String site) {
		this.time = time;
		this.site = site;
	}

	public int compareTo(Result r) {
		return time.compareTo(r.time);
	}
}
