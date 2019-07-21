package chapter03.section02.therad_3_2_4.project_1_joinLong;

public class Test {

	public static void main(String[] args) {
		try {
			MyThread threadTest = new MyThread();
			threadTest.start();

			// threadTest.join(2000);//只等2秒
			Thread.sleep(2000);
			// 两者有什么区别呢？

			System.out.println("  end timer=" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private static  class MyThread extends Thread {

		@Override
		public void run() {
			try {
				System.out.println("begin Timer=" + System.currentTimeMillis());
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
