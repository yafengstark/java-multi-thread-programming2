package chapter02.section02.thread_2_2_9.project_2_synTwoLock;

public class ThreadA extends Thread {
	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printA();
	}

}
