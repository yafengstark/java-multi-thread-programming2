package chapter01.section08_pause_thread;
/**
 * 使用suspend resume 独占锁问题
 */
public class T_1_8_2_suspend_resume_LockStop {

	public static void main(String[] args) {

		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println("main end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static  class MyThread extends Thread {
		private long i = 0;

		@Override
		public void run() {
			while (true) {
				i++;
				System.out.println(i);
			}
		}

	}
}
