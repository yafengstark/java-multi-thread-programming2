package chapter01.section07_stop_thread;

/**
 * 在沉睡中被停止
 *
 * 如果在sleep状态下停止某一个线程，会进入catch语句，并且清除停止状态值，使之变成false
 */
public class T_1_7_4_sleep_stop {


	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			try {
				System.out.println("run begin");
				Thread.sleep(200000);
				System.out.println("run end");
			} catch (InterruptedException e) {
				System.out.println("在沉睡中被停止!进入catch!"+this.isInterrupted());
				e.printStackTrace();
			}
		}
	}

}
