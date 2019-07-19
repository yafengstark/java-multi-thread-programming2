package chapter02.section02;

/**
 * 锁定的是不同的对象，产生脏数据
 */
public class Thread_2_2_7_synBlockString {

	public static void main(String[] args) {
		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

	static class Service {

		private String usernameParam;
		private String passwordParam;

		public void setUsernamePassword(String username, String password) {
			try {
				// 锁定的是不同的对象，产生脏数据
				String anyString = new String();
				synchronized (anyString) {
					System.out.println("线程名称为：" + Thread.currentThread().getName()
							+ "在" + System.currentTimeMillis() + "进入同步块");
					usernameParam = username;
					Thread.sleep(3000);
					passwordParam = password;
					System.out.println("线程名称为：" + Thread.currentThread().getName()
							+ "在" + System.currentTimeMillis() + "离开同步块");
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
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
			service.setUsernamePassword("a", "aa");

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
			service.setUsernamePassword("b", "bb");

		}

	}
}
