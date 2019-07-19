package chapter02.section02;

/**
 * 脏数据
 */
public class Thread_2_2_7_synBlockString2 {

	public static void main(String[] args) {
		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

	/**
	 * 锁定的是不同的对象
	 */
	static class Service {

		private String anyString = new String();

		public void a() {
			try {
				synchronized (anyString) { // 持有的是anyString的锁
					System.out.println("a begin");
					Thread.sleep(3000);
					System.out.println("a   end");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized public void b() { // 持有的是this锁
			System.out.println("b begin");
			System.out.println("b   end");
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
			service.a();

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
			service.b();

		}

	}
}
