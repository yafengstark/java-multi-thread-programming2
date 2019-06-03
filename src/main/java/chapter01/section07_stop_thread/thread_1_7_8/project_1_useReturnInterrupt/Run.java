package chapter01.section07_stop_thread.thread_1_7_8.project_1_useReturnInterrupt;

/**
 * 使用return 实现停止线程。
 *
 * 建议使用抛异常的方法停止线程
 */
public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyThread t=new MyThread();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}

}
