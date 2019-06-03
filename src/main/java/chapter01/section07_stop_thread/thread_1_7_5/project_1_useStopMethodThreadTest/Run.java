package chapter01.section07_stop_thread.thread_1_7_5.project_1_useStopMethodThreadTest;

/**
 * 暴力停止
 *
 */
public class Run {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(8000);
			thread.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
