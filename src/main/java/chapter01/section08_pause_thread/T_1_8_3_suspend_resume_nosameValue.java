package chapter01.section08_pause_thread;

/**
 * 不同步问题
 *
 */
public class T_1_8_3_suspend_resume_nosameValue {
	public static void main(String[] args) throws InterruptedException {

		final MyObject myobject = new MyObject();

		Thread thread1 = new Thread() {
			public void run() {
				myobject.setValue("a", "aa");
			};
		};
		thread1.setName("a");
		thread1.start();

		Thread.sleep(500);

		Thread thread2 = new Thread() {
			public void run() {
				myobject.printUsernamePassword();
			};
		};
		thread2.start();

	}

	static class MyObject {
		private String username = "1";
		private String password = "11";

		public void setValue(String u, String p) {
			this.username = u;
			if (Thread.currentThread().getName().equals("a")) {
				System.out.println("停止a线程！");
				Thread.currentThread().suspend();
			}
			this.password = p;
		}

		public void printUsernamePassword() {
			System.out.println(username + " " + password);
		}
	}

}
