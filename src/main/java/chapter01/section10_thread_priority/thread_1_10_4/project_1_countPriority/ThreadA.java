package chapter01.section10_thread_priority.thread_1_10_4.project_1_countPriority;

public class ThreadA extends Thread {

	private int count = 0;

	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		while (true) {
			count++;
		}
	}

}
