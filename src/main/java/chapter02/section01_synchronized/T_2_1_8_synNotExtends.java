package chapter02.section01_synchronized;

/**
 * 同步不具有继承性
 *
 */
public class T_2_1_8_synNotExtends {

	public static void main(String[] args) {
		Sub subRef = new Sub();

		MyThreadA a = new MyThreadA(subRef);
		a.setName("A");
		a.start();

		MyThreadB b = new MyThreadB(subRef);
		b.setName("B");
		b.start();
	}

	static class Main {

		synchronized public void serviceMethod() {
			try {
				System.out.println("int main 下一步 sleep begin threadName="
						+ Thread.currentThread().getName() + " time="
						+ System.currentTimeMillis());
				Thread.sleep(5000);
				System.out.println("int main 下一步 sleep   end threadName="
						+ Thread.currentThread().getName() + " time="
						+ System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static  class MyThreadA extends Thread {

		private Sub sub;

		public MyThreadA(Sub sub) {
			super();
			this.sub = sub;
		}

		@Override
		public void run() {
			sub.serviceMethod();
		}

	}

	static class MyThreadB extends Thread {

		private Sub sub;

		public MyThreadB(Sub sub) {
			super();
			this.sub = sub;
		}

		@Override
		public void run() {
			sub.serviceMethod();
		}
	}

	static class Sub extends Main {

		@Override
		synchronized public void serviceMethod() {
			try {
				System.out.println("int sub 下一步 sleep begin threadName="
						+ Thread.currentThread().getName() + " time="
						+ System.currentTimeMillis());
				Thread.sleep(5000);
				System.out.println("int sub 下一步 sleep   end threadName="
						+ Thread.currentThread().getName() + " time="
						+ System.currentTimeMillis());
				super.serviceMethod();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}


}
