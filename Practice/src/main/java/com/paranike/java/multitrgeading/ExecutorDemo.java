package com.paranike.java.multitrgeading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	private static class MyRunnable implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 10; i += 2) { // odd number generation
				try {
					Thread.sleep(500); // executors thred sleeping
					System.out.println(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Runnable r = new MyRunnable();

		ExecutorService s = Executors.newSingleThreadExecutor(); // creating a executor
		s.submit(r);
		// e.execute(r); // submitting and executing the task
		for (int i = 0; i <= 10; i += 2) { // even number generation
			try {
				Thread.sleep(500); // main-thread sleeping
				System.out.println(i);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		s.shutdown();

	}

}