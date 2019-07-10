package chapter02.section01_synchronized;


/**
 * 是可重入的
 *
 * 自己可以再次获取自己的内部锁
 *
 *
 */
public class T_2_1_6_synLockIn_1 {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			Service service = new Service();
			service.service1();
		}

	}

	static  class Service {

		synchronized public void service1() {
			System.out.println("service1");
			service2();
		}

		synchronized public void service2() {
			System.out.println("service2");
			service3();
		}

		synchronized public void service3() {
			System.out.println("service3");
		}

	}
}
