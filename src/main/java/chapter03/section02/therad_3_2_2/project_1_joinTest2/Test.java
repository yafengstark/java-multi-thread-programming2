package chapter03.section02.therad_3_2_2.project_1_joinTest2;

public class Test {

	public static void main(String[] args) {
		try {
			MyThread threadTest = new MyThread();
			threadTest.start();
			threadTest.join();// 阻塞住

			System.out.println("我想当threadTest对象执行完毕后我再执行，我做到了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class MyThread extends Thread {

		@Override
		public void run() {
			try {
				int secondValue = (int) (Math.random() * 10000);
				System.out.println(secondValue);
				Thread.sleep(secondValue);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
