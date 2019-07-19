package chapter02.section03.thread_2_3_5.project_1_AtomicIntegerTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类
 *
 */
public class Run {

	public static void main(String[] args) {
		AddCountThread countService = new AddCountThread();

		Thread t1 = new Thread(countService);
		t1.start();

		Thread t2 = new Thread(countService);
		t2.start();

		Thread t3 = new Thread(countService);
		t3.start();

		Thread t4 = new Thread(countService);
		t4.start();

		Thread t5 = new Thread(countService);
		t5.start();

	}

	static class AddCountThread extends Thread {
		private AtomicInteger count = new AtomicInteger(0);

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				System.out.println(count.incrementAndGet());
			}
		}
	}
}
