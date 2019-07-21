package chapter03.section01.therad_3_1_3.project_3_wait_notify_size5;

import java.util.ArrayList;
import java.util.List;

/**
 * 到5退出
 *
 * lock.notify()不会立即释放锁
 *
 * 仅通知一个线程
 *
 *
 */
public class Run {

	public static void main(String[] args) {

		try {
			Object lock = new Object();

			ThreadA a = new ThreadA(lock);
			a.start();

			Thread.sleep(50);

			ThreadB b = new ThreadB(lock);
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	static public class MyList {

		private static List list = new ArrayList();

		public static void add() {
			list.add("anyString");
		}

		public static int size() {
			return list.size();
		}

	}

	static class ThreadA extends Thread {

		private Object lock;

		public ThreadA(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				synchronized (lock) {
					if (MyList.size() != 5) {
						System.out.println("wait begin "
								+ System.currentTimeMillis());
						lock.wait();
						System.out.println("wait end  "
								+ System.currentTimeMillis());
						System.out.println("结束了线程a");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}


	static class ThreadB extends Thread {
		private Object lock;

		public ThreadB(Object lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						MyList.add();
						if (MyList.size() == 5) {
							lock.notify();
							System.out.println("已发出通知！");
						}
						System.out.println("添加了" + (i + 1) + "个元素!");
						Thread.sleep(1000);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}


}
