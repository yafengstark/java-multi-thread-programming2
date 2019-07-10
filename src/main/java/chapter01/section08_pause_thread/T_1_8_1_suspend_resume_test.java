package chapter01.section08_pause_thread;

/**
 * 暂停与恢复
 *
 */
public class T_1_8_1_suspend_resume_test {
	public static void main(String[] args) {

		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(5000);
			// A
			thread.suspend();
			System.out.println("A= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			Thread.sleep(5000);
			System.out.println("A= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			// B
			thread.resume();
			Thread.sleep(5000);

			// C
			thread.suspend();
			System.out.println("B= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			Thread.sleep(5000);
			System.out.println("B= " + System.currentTimeMillis() + " i="
					+ thread.getI());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class MyThread extends Thread {

		private long i = 0;

		public long getI() {
			return i;
		}

		public void setI(long i) {
			this.i = i;
		}

		@Override
		public void run() {
			while (true) {
				i++;
			}
		}

	}
}
