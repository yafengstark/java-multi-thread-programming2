package chapter01.section07_stop_thread;

public class T_1_7_3_InterruptedException_forprint {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
	/**
	 * 存在语句继续运行问题
	 */
	static class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 500000; i++) {
				if (this.interrupted()) {
					System.out.println("已经是停止状态了!我要退出了!");
					break;
				}
				System.out.println("i=" + (i + 1));
			}
			System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
		}
	}

}
