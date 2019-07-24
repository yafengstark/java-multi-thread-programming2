package chapter04.section01.thread_4_1_1.project_1_ReentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
	
	public static void main(String[] args) {

		MyService service = new MyService();

		MyThread a1 = new MyThread(service);
		MyThread a2 = new MyThread(service);
		MyThread a3 = new MyThread(service);
		MyThread a4 = new MyThread(service);
		MyThread a5 = new MyThread(service);

		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();

	}

	static class MyThread extends Thread {

		private MyService service;

		public MyThread(MyService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			service.testMethod();
		}
	}

	static class MyService {
		private Lock lock = new ReentrantLock();

		public void testMethod() {
			lock.lock();// 加锁
			for (int i = 0; i < 5; i++) {
				System.out.println("ThreadName=" + Thread.currentThread().getName()
						+ (" " + (i + 1)));
			}
			lock.unlock();// 释放锁
		}

	}

}
