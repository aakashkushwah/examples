package com.akushwah.examples.threads.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFiFo<T> {

	private Object[] eles = null;
	private int current = 0;
	private int placeIndex = 0;
	private int removeIndex = 0;

	private final Lock lock = new ReentrantLock();
	private final Condition isEmpty = lock.newCondition();
	private final Condition isFull = lock.newCondition();

	public SharedFiFo(int n) {
		this.eles = new Object[n];
	}

	public void put(T t) throws InterruptedException {
		lock.lock();
		if (current >= eles.length) {
			isFull.await();
		}
		eles[placeIndex] = t;
		placeIndex = (placeIndex + 1) % eles.length;
		++current;
		isEmpty.signal();
		lock.unlock();
	}

	public T take() throws InterruptedException {
		Object elem = null;
		lock.lock();
		if (current <= 0) {
			isEmpty.await();
		}
		elem = eles[removeIndex];
		removeIndex = (removeIndex + 1) % eles.length;
		--current;
		
		isFull.signal();
		lock.unlock();
		return (T) elem;
	}
}
