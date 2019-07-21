package chapter03.section01.therad_3_1_5.project_1_waitInterruptException;

/**
 * wait过程中调用interrupt()抛出异常InterruptedException
 */
public class Test {

	public static void main(String[] args) {

		try {
			Object lock = new Object();

			ThreadA a = new ThreadA(lock);
			a.start();

			Thread.sleep(5000);

			a.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	static class Service {

		public void testMethod(Object lock) {
			try {
				synchronized (lock) {
					System.out.println("begin wait()");
					lock.wait();
					System.out.println("  end wait()");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("出现异常了，因为呈wait状态的线程被interrupt了！");
			}
		}

	}
	static class ThreadA extends Thread {

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



}
