package chapter03.section01.therad_3_1_6.project_1_notifyOne;

/**
 * 调用notify()一次只随机通知一个线程进行唤醒
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();

		ThreadA a = new ThreadA(lock);
		a.start();

		ThreadB b = new ThreadB(lock);
		b.start();

		ThreadC c = new ThreadC(lock);
		c.start();

		Thread.sleep(1000);

		NotifyThread notifyThread = new NotifyThread(lock);
		notifyThread.start();

	}

	private static class Service {

		public void testMethod(Object lock) {
			try {
				synchronized (lock) {
					System.out.println("begin wait() ThreadName="
							+ Thread.currentThread().getName());
					lock.wait();
					System.out.println("  end wait() ThreadName="
							+ Thread.currentThread().getName());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static class ThreadA extends Thread {
		private Object lock;

		public ThreadA(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			Service service = new Service();
			service.testMethod(lock);
		}

	}

	private static  class ThreadB extends Thread {
		private Object lock;

		public ThreadB(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			Service service = new Service();
			service.testMethod(lock);
		}

	}

	private static class ThreadC extends Thread {
		private Object lock;

		public ThreadC(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			Service service = new Service();
			service.testMethod(lock);
		}

	}

	private static class NotifyThread extends Thread {
		private Object lock;

		public NotifyThread(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				lock.notify();
				lock.notify();
//				lock.notify();
//				lock.notify();
//				lock.notify();
//				lock.notify();
//				lock.notify();
//				lock.notify();
//				lock.notify();
			}
		}

	}


}
