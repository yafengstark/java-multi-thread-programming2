package chapter02.section02;

public class Thread_2_2_9_synStaticMethod {

	public static void main(String[] args) {

		// 依次执行

		ThreadA a = new ThreadA();
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB();
		b.setName("B");
		b.start();

	}

	private static class ThreadA extends Thread {
		@Override
		public void run() {
			Service.printA();
		}

	}

	private static class ThreadB extends Thread {
		@Override
		public void run() {
			Service.printB();
		}
	}

	private static  class Service {

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

		synchronized public static void printB() {
			System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
					+ System.currentTimeMillis() + "进入printB");
			System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
					+ System.currentTimeMillis() + "离开printB");
		}

	}
}
