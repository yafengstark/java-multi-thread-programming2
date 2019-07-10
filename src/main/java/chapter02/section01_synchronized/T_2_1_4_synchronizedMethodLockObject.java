package chapter02.section01_synchronized;
public class T_2_1_4_synchronizedMethodLockObject {

	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadA a = new ThreadA(object);
		a.setName("A");
		ThreadB b = new ThreadB(object);
		b.setName("B");

		a.start();
		b.start();
	}

	static class MyObject {

		synchronized public void methodA() {
			try {
				System.out.println("begin methodA threadName="
						+ Thread.currentThread().getName());
				Thread.sleep(5000);
				System.out.println("end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static class ThreadA extends Thread {

		private MyObject object;

		public ThreadA(MyObject object) {
			super();
			this.object = object;
		}

		@Override
		public void run() {
			super.run();
			object.methodA();
		}

	}

	static class ThreadB extends Thread {

		private MyObject object;

		public ThreadB(MyObject object) {
			super();
			this.object = object;
		}

		@Override
		public void run() {
			super.run();
			object.methodA();
		}
	}


}
