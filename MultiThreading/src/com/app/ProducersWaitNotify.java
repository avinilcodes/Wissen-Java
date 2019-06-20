package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducersWaitNotify {

	private static List<Integer> buffer = new ArrayList<>();
	private static int count;
	private static int evenOdd;
	private static Object lock = new Object();

	static boolean isOdd(List<Integer> buffer) {
		int i = buffer.get(count);
		if (i % 2 != 0)
			return true;
		else
			return false;
	}

	static boolean isEven(List<Integer> buffer) {
		int i = buffer.get(count);
		if (i % 2 == 0)
			return true;
		else
			return false;
	}

	static class EvenFactory {
		void produceEven() {
			synchronized (lock) {
				if (isEven(buffer)) {
					try {
						System.out.println("waiting for oddFactory");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if (evenOdd % 2 != 0)
					evenOdd++;
				System.out.println("even factory producing");
				buffer.add(evenOdd);
				count++;
				System.out.println(buffer.get(count));
				lock.notify();
			}

		}
	};

	static class OddFactory {
		void produceOdd() {
			synchronized (lock) {
				if (isOdd(buffer)) {
					try {
						System.out.println("waiting for EvenFactory");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("odd factory producing");
				if (evenOdd % 2 == 0)
					evenOdd++;
				buffer.add(evenOdd);
				count++;
				System.out.println(buffer.get(count));
				lock.notify();
			}

		}
	};

	public static void main(String[] args) throws InterruptedException {
		buffer.add(0);
		count = 0;
		evenOdd = 1;
		EvenFactory evenFactory = new EvenFactory();
		OddFactory oddFactory = new OddFactory();
		Runnable evenTask = () -> {
			for (int i = 0; i < 5; i++) {
				evenFactory.produceEven();
			}
			System.out.println("Done producing");
		};

		Runnable oddTask = () -> {
			for (int i = 0; i < 5; i++) {
				oddFactory.produceOdd();
			}
			System.out.println("Done producing");
		};
		Thread oddThread = new Thread(oddTask);
		Thread evenThread = new Thread(evenTask);

		oddThread.start();
		evenThread.start();

		oddThread.join();
		evenThread.join();
		System.out.println(buffer);
	}
}
