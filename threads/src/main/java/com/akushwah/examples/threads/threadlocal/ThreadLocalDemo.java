package com.akushwah.examples.threads.threadlocal;

class ParentThread extends Thread {
	// anonymous inner class for overriding childValue method.
//	public static InheritableThreadLocal gfg_tl = new InheritableThreadLocal() {
//		public Object childValue(Object parentValue) {
//			return "child data";
//		}
//	};
	
	public static InheritableThreadLocal gfg_tl = new InheritableThreadLocal();

	public void run() {
		// setting the new value
		gfg_tl.set("parent data");
		// parent data
		System.out.println("Parent Thread Value :" + gfg_tl.get());

		ChildThread gfg_ct = new ChildThread();
		gfg_ct.start();
	}
}

class ChildThread extends Thread {

	public void run() {
		// child data
		System.out.println("Child Thread Value :" + ParentThread.gfg_tl.get());
	}
}

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ParentThread gfg_pt = new ParentThread();
		gfg_pt.start();
	}
}
