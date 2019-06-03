package chapter01.section02.thread_1_2_4.project_1_smaeNum;

/**
 * i--操作是在进入println之前发生的。
 */
public class MyThread extends Thread {

	private int i = 5;

	@Override
	public void run() {
		System.out.println("i=" + (i--) + " threadName="
				+ Thread.currentThread().getName());
		// 注意，代码i-- 是在println中。
		// println 实现是加锁的。

	}

}
