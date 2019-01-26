package com.paranike.java.multithreading;

public class WaitNotify {

	public void waiter() throws InterruptedException {
		synchronized (this) {
			System.out.println("Am in Waiter, Still Excuting");
			// Now it will start waiting and release lock as well.
			wait();

			System.out.println("Executing after notification!!!");

		}
	}

	public void notifier() throws InterruptedException {
		// Both wait and notify should be locked using same object.
		synchronized (this) {
			System.out.println("Am in notifer, Still Excuting");
			// Now it will notify but will not release lock till it executes subsequent
			// statements in locked block .
			notify();
			System.out.println("Executing after notifying!!!");
			Thread.sleep(1000);
			System.out.println("Even though notifed other but will release lock now!!!");

		}
	}

	public static void main(String[] args) throws InterruptedException {
		WaitNotify obj = new WaitNotify();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					obj.waiter();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					obj.notifier();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t1.start();
		t2.start();
	}

}
