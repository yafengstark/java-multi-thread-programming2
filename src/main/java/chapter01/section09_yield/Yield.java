package chapter01.section09_yield;

/**
 * yield放弃当前的CPU资源，
 *
 * 放弃时间不确定
 *
 */
public class Yield {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
	}

	static  class MyThread extends Thread {

		@Override
		public void run() {
			long beginTime = System.currentTimeMillis();
			int count = 0;
			for (int i = 0; i < 50000000; i++) {
				Thread.yield();
				count = count + (i + 1);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("用时：" + (endTime - beginTime) + "毫秒！");
		}

	}
}
