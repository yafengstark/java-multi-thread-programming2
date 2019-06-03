package chapter01.section07_stop_thread.thread_1_7_4.project_1_t14;

/**
 * 在沉睡中被停止
 *
 * 如果在sleep状态下停止某一个线程，会进入catch语句，并且清除停止状态值，使之变成false
 */
public class Run {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
