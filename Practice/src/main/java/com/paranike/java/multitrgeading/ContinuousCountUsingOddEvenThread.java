package com.paranike.java.multitrgeading;

public class ContinuousCountUsingOddEvenThread {
	private volatile boolean isEvenTurn = true;

	public void printEven() throws InterruptedException {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				if (!isEvenTurn) {
					wait();
				}

				if (i % 2 == 0) {
					System.out.println(i);
					isEvenTurn = !isEvenTurn;
					notifyAll();
				}

			}
		}
	}

	public void printOdd() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				if (isEvenTurn) {
					wait();
				}
				if (i % 2 == 1) {
					System.out.println(i);
					isEvenTurn = !isEvenTurn;
					notifyAll();
				}

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ContinuousCountUsingOddEvenThread obj = new ContinuousCountUsingOddEvenThread();
		Thread t1 = new Thread(() -> {
			try {
				obj.printEven();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					obj.printOdd();
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
