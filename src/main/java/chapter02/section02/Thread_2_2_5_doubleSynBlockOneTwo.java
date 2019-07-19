package chapter02.section02;

public class Thread_2_2_5_doubleSynBlockOneTwo {

	public static void main(String[] args) {

		/**
		 * 锁定同一个对象，
		 *
		 * 使用的对象监听器是一个
		 */
		ObjectService service = new ObjectService();

		ThreadA a = new ThreadA(service);
		a.setName("a");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("b");
		b.start();
	}

	/**
	 * 有两个同步方法
	 */
	static class ObjectService {

		public void serviceMethodA() {
			try {
				synchronized (this) {
					System.out.println("A begin time=" + System.currentTimeMillis());
					Thread.sleep(2000);
					System.out.println("A end    end=" + System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void serviceMethodB() {
			synchronized (this) {
				System.out.println("B begin time=" + System.currentTimeMillis());
				System.out.println("B end    end=" + System.currentTimeMillis());
			}
		}
	}

	static class ThreadA extends Thread {

		private ObjectService service;

		public ThreadA(ObjectService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.serviceMethodA();
		}

	}

	static class ThreadB extends Thread {
		private ObjectService service;

		public ThreadB(ObjectService service) {
			super();
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.serviceMethodB();
		}
	}


}
