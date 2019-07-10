package chapter01.section07_stop_thread;

/**
 * 使用stop暴力停止,
 *
 */
public class T_1_7_5_useStopMethodThreadTest {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(8000);
			thread.stop();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	static class MyThread extends Thread {
		private int i = 0;

		@Override
		public void run() {
			try {
				while (true) {
					i++;
					System.out.println("i=" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
