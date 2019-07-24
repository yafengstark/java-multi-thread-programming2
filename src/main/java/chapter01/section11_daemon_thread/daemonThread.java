package chapter01.section11_daemon_thread;

public class daemonThread {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("我离开thread对象也不再打印了，也就是停止了！");
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
					System.out.println("i=" + (i));
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {



				e.printStackTrace();
			}
		}

	}
}
