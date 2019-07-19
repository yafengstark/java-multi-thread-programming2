package chapter02.section02.thread_2_2_12.project_1_deadLockTest;

/**
 * 一个死锁的样例
 *
 * 如何查看是否有死锁的现象
 */
public class Run {

	public static void main(String[] args) {
		try {
			DealThread t1 = new DealThread();
			t1.setFlag("a");

			Thread thread1 = new Thread(t1);
			thread1.start();

			Thread.sleep(100);

			t1.setFlag("b");

			Thread thread2 = new Thread(t1);
			thread2.start();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}