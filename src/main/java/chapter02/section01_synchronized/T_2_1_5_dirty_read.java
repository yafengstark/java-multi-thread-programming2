package chapter02.section01_synchronized;

public class T_2_1_5_dirty_read {

	public static void main(String[] args) {
		try {
			PublicVar publicVarRef = new PublicVar();
			ThreadA thread = new ThreadA(publicVarRef);
			thread.start();

			Thread.sleep(200);// ��ӡ����ܴ�ֵ��СӰ��

			publicVarRef.getValue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	static class PublicVar {

		public String username = "A";
		public String password = "AA";

		synchronized public void setValue(String username, String password) {
			try {
				this.username = username;
				Thread.sleep(5000);
				this.password = password;

				System.out.println("setValue method thread name="
						+ Thread.currentThread().getName() + " username="
						+ username + " password=" + password);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized public void getValue() {
			System.out.println("getValue method thread name="
					+ Thread.currentThread().getName() + " username=" + username
					+ " password=" + password);
		}
	}

	static class ThreadA extends Thread {

		private PublicVar publicVar;

		public ThreadA(PublicVar publicVar) {
			super();
			this.publicVar = publicVar;
		}

		@Override
		public void run() {
			super.run();
			publicVar.setValue("B", "BB");
		}
	}
}
