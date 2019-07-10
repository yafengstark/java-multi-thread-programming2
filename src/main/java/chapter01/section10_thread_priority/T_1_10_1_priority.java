package chapter01.section10_thread_priority;

/**
 * 优先级的继承性
 *
 */
public class T_1_10_1_priority {

	public static void main(String[] args) {
		System.out.println("main thread begin priority="
				+ Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main thread end   priority="
				+ Thread.currentThread().getPriority());
		MyThread1 thread1 = new MyThread1();
		thread1.start();
	}

	static  class MyThread1 extends Thread {
		@Override
		public void run() {
			System.out.println("MyThread1 run priority=" + this.getPriority());
			MyThread2 thread2 = new MyThread2();
			thread2.start();
		}

	}

	static  class MyThread2 extends Thread {
		@Override
		public void run() {
			System.out.println("MyThread2 run priority=" + this.getPriority());
		}

	}
}
