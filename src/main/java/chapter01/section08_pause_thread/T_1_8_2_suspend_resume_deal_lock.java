package chapter01.section08_pause_thread;

/**
 * 使用suspend resume 独占锁问题
 */
public class T_1_8_2_suspend_resume_deal_lock {
	public static void main(String[] args) {
		try {
			final SynchronizedObject object = new SynchronizedObject();

			Thread thread1 = new Thread() {
				@Override
				public void run() {
					object.printString();
				}
			};

			thread1.setName("a");
			thread1.start();

			Thread.sleep(1000);

			Thread thread2 = new Thread() {
				@Override
				public void run() {
					System.out
							.println("thread2启动了，但进入不了printString()方法！只打印1个begin");
					System.out
							.println("因为printString()方法被a线程锁定并且永远的suspend暂停了！");
					object.printString();
				}
			};
			thread2.start();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	static class SynchronizedObject {

		synchronized public void printString() {
			System.out.println("begin");
			if (Thread.currentThread().getName().equals("a")) {
				System.out.println("a线程永远 suspend了！");
				Thread.currentThread().suspend();
			}
			System.out.println("end");
		}
	}
}
