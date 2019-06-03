package chapter03.section01.therad_3_1_7.project_1_notifyAll;


public class NotifyThread extends Thread {
	private Object lock;

	public NotifyThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}

}
