package chapter02.section03.thread_2_3_4.project_1_volatileTestThread;

/**
 * volatile 不能保证原子性
 *
 */
public class Run {
	public static void main(String[] args) {
		MyThread[] mythreadArray = new MyThread[1000];
		for (int i = 0; i < 1000; i++) {
			mythreadArray[i] = new MyThread();
		}

		for (int i = 0; i < 1000; i++) {
			mythreadArray[i].start();
		}

	}


	static class MyThread extends Thread {
		public volatile static int count;

		/** synchronized **/ private static void addCount() {
			for (int i = 0; i < 1000; i++) {
				count++;
			}
			System.out.println("count=" + count);
		}

		@Override
		public void run() {
			addCount();
		}

	}
}
