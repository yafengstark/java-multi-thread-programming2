package chapter03.section01.therad_3_1_1.project_1_TwoThreadTransData;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;

/**
 * 轮询浪费时间
 *
 *
 */
public class Test {

	public static void main(String[] args) {
		MyList service = new MyList();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}


	private static class MyList {

		private List list = new ArrayList();

		public void add() {
			list.add("高洪岩");
		}

		public int size() {
			return list.size();
		}

	}

	static class ThreadA extends Thread {

		private MyList list;

		public ThreadA(MyList list) {
			super();
			this.list = list;
		}

		@Override
		public void run() {
			System.out.println("启动了a");

			try {
				for (int i = 0; i < 10; i++) {
					list.add();
					System.out.println("添加了" + (i + 1) + "个元素");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static class ThreadB extends Thread {

		private MyList list;

		public ThreadB(MyList list) {
			super();
			this.list = list;
		}

		@Override
		public void run() {
			System.out.println("启动了b");
			try {
				while (true) {
					if (list.size() == 5) {
						System.out.println("==5了，线程b要退出了！");
						throw new InterruptedException();
					}
					System.out.println(list.size());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
