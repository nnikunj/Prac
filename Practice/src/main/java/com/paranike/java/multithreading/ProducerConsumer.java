package com.paranike.java.multithreading;

import java.util.Random;

public class ProducerConsumer {

	private volatile boolean isProduced = false;
	private volatile Integer itemProduced = null;

	public void produce() {
		Random rand = new Random();
		synchronized (this) {
			while (true) {
				if (isProduced) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (!isProduced) {
					itemProduced = rand.nextInt(10);
					System.out.println("Item Produced.");
					isProduced = true;
					notifyAll();
				}

			}
		}
	}

	public void consume() {
		synchronized (this) {
			while (true) {
				if (!isProduced) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (isProduced) {
					System.out.println("Consuming production :" + itemProduced);
					isProduced = false;
					itemProduced = null;
					notifyAll();
				}

			}
		}
	}

	public static void main(String[] args) {
		ProducerConsumer factory = new ProducerConsumer();

		Thread t1 = new Thread(() -> factory.produce());
		Thread t2 = new Thread(() -> factory.consume());

		t1.start();
		t2.start();
	}

}
