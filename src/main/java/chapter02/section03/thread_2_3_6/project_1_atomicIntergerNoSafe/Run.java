package chapter02.section03.thread_2_3_6.project_1_atomicIntergerNoSafe;

import java.util.concurrent.atomic.AtomicLong;

public class Run {

	public static void main(String[] args) {
		try {
			MyService service = new MyService();

			MyThread[] array = new MyThread[5];
			for (int i = 0; i < array.length; i++) {
				array[i] = new MyThread(service);
			}
			for (int i = 0; i < array.length; i++) {
				array[i].start();
			}

			Thread.sleep(1000);

			System.out.println(service.aiRef.get());
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


	static class MyService {

		public static AtomicLong aiRef = new AtomicLong();

		/**synchronized**/ public void addNum() {
			System.out.println(Thread.currentThread().getName() + "加了100之后的值是:"
					+ aiRef.addAndGet(100));
			aiRef.addAndGet(1);
		}

	}


	static class MyThread extends Thread {
		private MyService mySerivce;

		public MyThread(MyService mySerivce) {
			super();
			this.mySerivce = mySerivce;
		}

		@Override
		public void run() {
			mySerivce.addNum();
		}

	}

}
