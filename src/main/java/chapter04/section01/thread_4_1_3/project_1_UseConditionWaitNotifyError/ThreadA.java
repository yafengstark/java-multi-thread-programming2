package chapter04.section01.thread_4_1_3.project_1_UseConditionWaitNotifyError;

public class ThreadA extends Thread {

	private MyService service;

	public ThreadA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.await();
	}
}

