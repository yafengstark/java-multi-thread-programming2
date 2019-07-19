package chapter02.section03.thread_2_3_7.project_1_synchronizedUpdateNewValue;

/**
 * synchronized 即可保证互斥性，又可保证可见性（间接）
 *
 */
public class Run {

	public static void main(String[] args) {
		try {
			Service service = new Service();

			ThreadA a = new ThreadA(service);
			a.start();

			Thread.sleep(1000);

			ThreadB b = new ThreadB(service);
			b.start();

			System.out.println("已经发起停止的命令了！");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	static class Service {

		private boolean isContinueRun = true;

		public void runMethod() {
			String anyString = new String();
			while (isContinueRun == true) {
				synchronized (anyString) {
				}
			}
			System.out.println("停下来了！");
		}

		public void stopMethod() {
			isContinueRun = false;
		}
	}

	static class ThreadA extends Thread {
		private Service service;

		public ThreadA(Service service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			service.runMethod();
		}
	}
	static class ThreadB extends Thread {
		private Service service;

		public ThreadB(Service service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			service.stopMethod();
		}

	}
}
