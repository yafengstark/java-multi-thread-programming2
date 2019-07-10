package chapter01.section07_stop_thread;

/**
 * 使用stop() 释放锁将会给数据造成不一致性的结构
 *
 */
public class T_1_7_7_stopThrowLock {



	public static void main(String[] args) {
		try {
			SynchronizedObject object = new SynchronizedObject();
			MyThread thread = new MyThread(object);
			thread.start();
			Thread.sleep(500);
			thread.stop();
			System.out.println(object.getUsername() + " "
					+ object.getPassword());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static class SynchronizedObject {
		private String username = "a";
		private String password = "aa";

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		synchronized public void printString(String username, String password) {
			try {
				this.username = username;
				Thread.sleep(100000);
				this.password = password;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class MyThread extends Thread {

		private SynchronizedObject object;

		public MyThread(SynchronizedObject object) {
			super();
			this.object = object;
		}

		@Override
		public void run() {
			object.printString("b", "bb");
		}

	}
}
