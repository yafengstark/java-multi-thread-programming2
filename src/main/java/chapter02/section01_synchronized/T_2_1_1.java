package chapter02.section01_synchronized;

/**
 * 方法内部的私有变量不存在线程安全问题
 *
 */
public class T_2_1_1 {
	public static void main(String[] args) {

		HasSelfPrivateNum numRef = new HasSelfPrivateNum();

		ThreadA athread = new ThreadA(numRef);
		athread.start();

		ThreadB bthread = new ThreadB(numRef);
		bthread.start();

	}

	static class HasSelfPrivateNum {

		public void addI(String username) {
			try {
				int num = 0;
				if (username.equals("a")) {
					num = 100;
					System.out.println("a set over!");
					Thread.sleep(2000);
				} else {
					num = 200;
					System.out.println("b set over!");
				}
				System.out.println(username + " num=" + num);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	static  class ThreadA extends Thread {

		private HasSelfPrivateNum numRef;

		public ThreadA(HasSelfPrivateNum numRef) {
			super();
			this.numRef = numRef;
		}

		@Override
		public void run() {
			super.run();
			numRef.addI("a");
		}


	}

	static class ThreadB extends Thread {

		private HasSelfPrivateNum numRef;

		public ThreadB(HasSelfPrivateNum numRef) {
			super();
			this.numRef = numRef;
		}

		@Override
		public void run() {
			super.run();
			numRef.addI("b");
		}

	}
}
