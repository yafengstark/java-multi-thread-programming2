package chapter02.section02;

public class Thread_2_2_4 {

	public static void main(String[] args) {
		Task task = new Task();

		MyThread1 thread1 = new MyThread1(task);
		thread1.start();

		MyThread2 thread2 = new MyThread2(task);
		thread2.start();
	}

	static class MyThread1 extends Thread {

		private Task task;

		public MyThread1(Task task) {
			super();
			this.task = task;
		}

		@Override
		public void run() {
			super.run();
			task.doLongTimeTask();
		}

	}

	static  class MyThread2 extends Thread {

		private Task task;

		public MyThread2(Task task) {
			super();
			this.task = task;
		}

		@Override
		public void run() {
			super.run();
			task.doLongTimeTask();
		}

	}

	static class Task {

		public void doLongTimeTask() {
			for (int i = 0; i < 100; i++) {
				System.out.println("nosynchronized threadName="
						+ Thread.currentThread().getName() + " i=" + (i + 1));
			}
			System.out.println("");
			synchronized (this) {
				for (int i = 0; i < 100; i++) {
					System.out.println("synchronized threadName="
							+ Thread.currentThread().getName() + " i=" + (i + 1));
				}
			}

		}
	}
}
