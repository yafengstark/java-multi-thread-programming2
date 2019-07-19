package chapter02.section02.thread_2_2_9.project_2_synTwoLock;

/**
 * 持有不同的锁
 *
 * 异步的
 */
public class Run {

	public static void main(String[] args) {

		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		ThreadC c = new ThreadC(service);
		c.setName("C");
		c.start();

	}

	static class Service {

		/**
		 * Class锁, 对类的所有对象实例起作用
		 */
		synchronized public static void printA() {
			try {
				System.out.println("线程名称为：" + Thread.currentThread().getName()
						+ "在" + System.currentTimeMillis() + "进入printA");
				Thread.sleep(3000);
				System.out.println("线程名称为：" + Thread.currentThread().getName()
						+ "在" + System.currentTimeMillis() + "离开printA");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/**
		 * Class锁
		 */
		synchronized public static void printB() {
			System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
					+ System.currentTimeMillis() + "进入printB");
			System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
					+ System.currentTimeMillis() + "离开printB");
		}

		synchronized public void printC() {
			System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
					+ System.currentTimeMillis() + "进入printC");
			System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
					+ System.currentTimeMillis() + "离开printC");
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
			service.printA();
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
			service.printB();
		}
	}

	static class ThreadC extends Thread {

		private Service service;

		public ThreadC(Service service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			service.printC();
		}
	}
}
