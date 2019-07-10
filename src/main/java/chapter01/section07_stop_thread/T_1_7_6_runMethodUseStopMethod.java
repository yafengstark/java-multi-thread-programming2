package chapter01.section07_stop_thread;

/**
 * 有时会抛出异常
 *
 * 不需捕获的
 *
 *
 *
 */
public class T_1_7_6_runMethodUseStopMethod {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			try {
				this.stop();
			} catch (ThreadDeath e) {
				System.out.println("进入了catch()方法！");
				e.printStackTrace();
			}
		}

	}
}
