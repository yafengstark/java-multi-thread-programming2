package chapter03.section01.therad_3_1_3.project_2_test2;

public class Test {
	public static void main(String[] args) {
		try {
			Object lock = new Object();

			MyThread1 t1 = new MyThread1(lock);
			t1.start();

			Thread.sleep(3000);

			MyThread2 t2 = new MyThread2(lock);
			t2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	static class MyThread1 extends Thread {
		private Object lock;

		public MyThread1(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				synchronized (lock) {
					System.out.println("开始      wait time=" + System.currentTimeMillis());
					lock.wait();
					System.out.println("结束      wait time=" + System.currentTimeMillis());
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	static class MyThread2 extends Thread {
		private Object lock;

		public MyThread2(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("开始notify time=" + System.currentTimeMillis());
				lock.notify();
				System.out.println("结束notify time=" + System.currentTimeMillis());
			}
		}
	}

}
