package chapter03.section01.therad_3_1_4.project_2_notifyHoldLock;

/**
 *  notify被执行完， 锁不会被自动释放
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();

		ThreadA a = new ThreadA(lock);
		a.start();

		NotifyThread notifyThread = new NotifyThread(lock);
		notifyThread.start();

		synNotifyMethodThread c = new synNotifyMethodThread(lock);
		c.start();

	}

}
