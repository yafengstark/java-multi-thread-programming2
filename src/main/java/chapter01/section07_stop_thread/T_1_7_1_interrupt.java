package chapter01.section07_stop_thread;
/**
 * interrupt() 停止线程，实际上不成功
 */
public class T_1_7_1_interrupt {


	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();// 停止线程，实际上不成功


		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 500000; i++) {
				System.out.println("i=" + (i + 1));
			}
		}
	}

}

