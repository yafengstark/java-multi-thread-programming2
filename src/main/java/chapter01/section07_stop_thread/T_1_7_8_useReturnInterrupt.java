package chapter01.section07_stop_thread;

/**
 * 使用return 实现停止线程。
 *
 * 建议使用抛异常的方法停止线程
 */
public class T_1_7_8_useReturnInterrupt {

	public static void main(String[] args) throws InterruptedException {
		MyThread t=new MyThread();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}

	static class MyThread extends Thread {

		@Override
		public void run() {
			while (true) {
				if (this.isInterrupted()) {
					System.out.println("停止了!");
					return;
				}
				System.out.println("timer=" + System.currentTimeMillis());
			}
		}

	}
}
